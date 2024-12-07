import { getIcon } from '../../../components/icons/getIcon';

export default function EventsCard() {
    return {
        type: 'Container',
        props: {className: 'z-10 absolute bottom-[60px] right-[60px]'},
        children: [
            {
                type: 'Container',
                props: {
                    contextTiedTo: 'eventsCard',
                    existValue: {
                        include: 0,
                        mainButton: 1,
                    },
                },
                children: [
                    {
                        type: 'Button',
                        props: {
                            clickBehaviour: 'change_context',
                            clickContext: 'eventsCard',
                            newContextValue: {mainButton: 0},
                            className: 'w-[100px] h-[60px] flex items-center justify-center bg-white rounded-[12px] shadow-[0px_0px_4px_1px_#00000020]'
                        },
                        children: [
                            {
                                type: 'Text',
                                props: {
                                    text: 'Activités',
                                    className: 'text-lg text-center font-bold'
                                }
                            }]
                    }
                ]
            },
            {
                type: 'Container',
                props: {
                    contextTiedTo: 'eventsCard',
                    existValue: {
                        include: 0,
                        mainButton: 0,
                    },
                    className: 'w-[650px] h-[calc(100vh-120px)] px-2 pb-2 pt-1 flex flex-col items-center bg-white rounded-[12px] shadow-[0px_0px_4px_1px_#00000020]'
                },
                children: [
                    {
                        type: 'Container',
                        props: {
                            contextTiedTo: 'eventsCard',
                            existValue: {
                                include: 0,
                                selectedId: '',
                            },
                            className: 'w-full h-fit mb-1 flex items-center justify-center'
                        },
                        children: [
                            {
                                type: 'Container',
                                props: {className: 'w-[20px] h-[20px]'},
                            },
                            {
                                type: 'Text',
                                props: {text: 'Activités', className: 'font-bold text-center text-lg flex-grow'}
                            },
                            {
                                type: 'Button',
                                props: {
                                    clickBehaviour: 'change_context',
                                    clickContext: 'eventsCard',
                                    newContextValue: {mainButton: 1, selectedId: ''},
                                },
                                children: [
                                    getIcon('xIcon', {className: 'w-[28px] h-[28px]'})
                                ]
                            }
                    ]
                    },
                    {
                        type: 'Container',
                        props: {
                            contextTiedTo: 'eventsCard',
                            existValue: {
                                include: 0,
                                selectedId: '',
                            },
                            className: 'w-full h-full rounded-[12px] shadow-[inset_0px_-4px_10px_0px_rgba(0,_0,_0,_0.2)] overflow-hidden'
                        },
                        children: [{
                            type: 'SduiCall', 
                            props: { macroComponentName: 'EventList', context: 'eventFilters' }
                        }]
                    },
                    {
                        type: 'SduiCall', 
                        props: { macroComponentName: 'EventDisplay', context: 'eventsCard' }
                    }
                ]
            }
        ]
    }
}