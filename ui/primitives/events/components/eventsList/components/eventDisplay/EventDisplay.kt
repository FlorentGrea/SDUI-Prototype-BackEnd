import { getIcon } from '@/app/api/sdui/userInterface/components/icons/getIcon';

export default async function eventDisplay() {
    const response = await fetch(`http://localhost:3000/api/eventPicked`);
    const eventPicked = await response.json();

    if (eventPicked.id == '') {
        return {
            type: 'Container',
            props: {
                className: 'hidden'
            }
        };
    }
    return {
        type: 'Container',
        props: {
            contextTiedTo: 'eventsCard',
            existValue: {
                include: 0,
                selectedId: eventPicked.id,
            },
            className: 'mt-1 p-1 flex flex-col gap-[8px] w-full h-full'
        },
        children: [
            {
                type: 'Container',
                props: {className: 'absolute top-[20px] left-[20px] w-[40px] h-[28px] flex items-center justify-center bg-white rounded-full shadow-[0_0_10px_0_rgba(0,0,0,0.1)]'},
                children: [getIcon(eventPicked.type, {className: 'w-[20px] h-[20px]'})]
            },
            {
                type: 'Button',
                props: {
                    clickBehaviour: 'change_context',
                    clickContext: 'eventsCard',
                    newContextValue: {
                        selectedId: ''
                    },
                    className: 'absolute top-[20px] right-[20px] w-[28px] h-[28px] flex items-center justify-center bg-white rounded-full shadow-[0_0_10px_0_rgba(0,0,0,0.1)]'
                },
                children: [getIcon('xIcon', {className: 'w-[20px] h-[20px]'})]
            },
            {
                type: 'Image',
                props: {
                    src: eventPicked.images[0] ? process.env.DB_ADDR + 'api/files/' + eventPicked.collectionId + '/' + eventPicked.id + '/' + eventPicked.images[0] : '', 
                    width: 1500, 
                    height: 1500, 
                    alt: '', 
                    className: 'w-full h-[300px] object-cover rounded-[12px]'
                }
            },
            {
                type: 'Text',
                props: {
                    text: eventPicked.title,
                    className: 'w-full h-[28px] font-bold text-[20px] text-left line-clamp-1 flex items-center'
                }
            },
            {
                type: 'Container',
                props: {className: 'w-full h-[60px] grid grid-cols-[3fr_1fr] grid-rows-[1fr_1fr]'},
                children: [{
                        type: 'Container',
                        props: {className: 'flex flex-row gap-[4px] items-center col-start-1 row-start-1'},
                        children: [
                            getIcon('locationIcon', {className: 'w-[20px] h-[20px]'}), 
                            {type: 'Text', props: {text: eventPicked.location, className: 'font-bold text-[16px] line-clamp-1'}}
                    ]}, {
                        type: 'Container',
                        props: {className: 'flex flex-row gap-[4px] items-center col-start-1 row-start-2'},
                        children: [
                            getIcon('calendarIcon', {className: 'w-[20px] h-[20px]'}), 
                            {type: 'Text', props: {text: new Date(eventPicked.date).toDateString(), className: 'font-bold text-[16px] line-clamp'}}
                    ]}, {
                        type: 'Container',
                        props: {className: 'w-full col-start-2 row-start-1 row-span-2'},
                        children: [{
                            type: 'Container', 
                            props: {className: 'flex flex-col items-center justify-evenly w-full h-full rounded-xl text-[16px] bg-black text-white'}, 
                            children: [{
                                    type: 'Container', 
                                    props: {className: 'flex flex-row items-center justify-center gap-1'}, 
                                    children: [
                                        {type: 'Text', props: {text: '3/4', className: 'font-bold text-[16px] h-[20px]'}}, 
                                        getIcon('twoPeopleIcon', {className: 'w-[20px] h-[20px] invert'})
                                ]}, {
                                    type: 'Text', 
                                    props: {text: '1000€', className: 'font-bold line-clamp w-fit'}
                            }]
                        }]
                    }
                ]
            }, {
                type: 'Container',
                props: {className: 'w-full h-[60px] flex flex-row gap-[4px] items-center'},
                children: [
                    {
                        type: 'Image',
                        props: {
                            src: eventPicked.images[0] ? process.env.DB_ADDR + 'api/files/' + eventPicked.collectionId + '/' + eventPicked.id + '/' + eventPicked.images[0] : '', 
                            width: 1500, 
                            height: 1500, 
                            alt: '', 
                            className: 'w-[60px] h-[60px] object-cover rounded-full'
                        }
                    }, {
                        type: 'Container',
                        props: {className: 'h-full flex flex-col justify-evenly'},
                        children: [{
                            type: 'Text', props: {text: 'Kevin Cosmon', className: 'font-bold text-[16px] line-clamp-1'}},
                            {type: 'Text', props: {text: '29 ans - Français', className: 'font-bold text-[16px] line-clamp-1'}}
                        ]
                    }
                ]
            }, {
                type: 'Text', props: {text: eventPicked.description, className: 'h-fit text-[16px]'}
            }
        ]
    }
}