package com.fgrea.ui.primitives.events.components.eventsList.components.eventCards

import com.fgrea.ui.components.icons.IconManager
import { MapPoint } from '@/types/map';
import PocketBase from 'pocketbase';

async function fetchFilteredMapPoints(): Promise<MapPoint[]> {
    try {
        const response = await fetch(`http://localhost:3000/api/filters`);
        if (!response.ok) {
            throw new Error('Failed to fetch suggestions');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching suggestions:', error);
        return [];
}}

export default async function eventList() {
    const pb = new PocketBase(process.env.DB_ADDR);
    let mapPoints: MapPoint[] = [];
    
    mapPoints = await fetchFilteredMapPoints();

    if (mapPoints.length === 0) {
        try {
            mapPoints = await pb.collection('MapPoints').getFullList({ next: { tags: ['mapPoints'] } });
        } catch (error) {
            console.error("Error fetching map points:", error);
        }
    }

    const events = mapPoints.map((point: MapPoint) => ({
        type:'Button',
        props:{
            clickBehaviour: 'post_context',
            clickContext: 'eventsCard',
            urlName: '/api/eventPicked',
            newContextValue: {selectedId: point.id},
            className: 'relative flex flex-col w-full h-fit',
        },
        children: [
            {
                type: 'Container',
                props: {className: 'absolute top-2 left-2 flex items-center justify-center w-[28px] h-[20px] rounded-full bg-white shadow-[0px_0px_4px_1px_#00000060]'},
                children: [getIcon(point.type, {className: 'w-[16px] h-[16px]'})]
            },{
                type: 'Image',
                props: {
                    src: point.images[0] ? process.env.DB_ADDR + 'api/files/' + point.collectionId + '/' + point.id + '/' + point.images[0] : '', 
                    width: 1500, 
                    height: 1500, 
                    alt: '', 
                    className: 'w-full h-[200px] object-cover rounded-[12px]'
            }}, {
                type: 'Text',
                props: {text: point.title, className: 'w-full my-[8px] h-fit font-bold text-[16px] text-left line-clamp-1'}
            }, {
                type: 'Container',
                props: {className: 'w-full h-[40px] grid grid-cols-[3fr_1fr] grid-rows-[1fr_1fr]'},
                children: [{
                        type: 'Container',
                        props: {className: 'flex flex-row gap-[4px] items-center col-start-1 row-start-1'},
                        children: [
                            getIcon('locationIcon', {className: 'w-[20px] h-[20px]'}), 
                            {type: 'Text', props: {text: point.location, className: 'font-bold text-[12px] line-clamp-1'}}
                    ]}, {
                        type: 'Container',
                        props: {className: 'flex flex-row gap-[4px] items-center col-start-1 row-start-2'},
                        children: [
                            getIcon('calendarIcon', {className: 'w-[20px] h-[20px]'}), 
                            {type: 'Text', props: {text: new Date(point.date).toDateString(), className: 'font-bold text-[12px] line-clamp'}}
                    ]}, {
                        type: 'Container',
                        props: {className: 'w-full col-start-2 row-start-1 row-span-2'},
                        children: [{
                            type: 'Container', 
                            props: {className: 'flex flex-col items-center justify-evenly w-full h-full rounded-xl text-[12px] bg-black text-white'}, 
                            children: [{
                                    type: 'Container', 
                                    props: {className: 'flex flex-row items-center justify-center gap-1'}, 
                                    children: [
                                        {type: 'Text', props: {text: '3/4', className: 'font-bold text-[12px] h-[20px]'}}, 
                                        getIcon('twoPeopleIcon', {className: 'w-[20px] h-[20px] invert'})
                                ]}, {
                                    type: 'Text', 
                                    props: {text: '1000€', className: 'font-bold line-clamp w-fit'}
                            }]
                        }]
                    }
                ]}
            ]
        }
    ))

    return {
        type: 'Container',
        props: {
            className: `
                w-full 
                h-full 
                pr-3         /* Add padding-right to account for scrollbar */
                overflow-y-auto 
                grid 
                grid-cols-2 
                gap-[12px] 
                p-[12px] 
                [&::-webkit-scrollbar]:w-2 
                [&::-webkit-scrollbar-track]:bg-transparent  /* Make track transparent */
                [&::-webkit-scrollbar-thumb]:bg-gray-300 
                [&::-webkit-scrollbar-thumb]:rounded-full 
                hover:[&::-webkit-scrollbar-thumb]:bg-gray-400
                [&::-webkit-scrollbar]:ml-1              /* Add margin to move scrollbar away from edge */
            `
        },
        children: events
    }
}

fun bedIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M208,68H28V48A12,12,0,0,0,4,48V208a12,12,0,0,0,24,0V180H228v28a12,12,0,0,0,24,0V112A44.04978,44.04978,0,0,0,208,68ZM28,92H92v64H28Zm88,64V92h92a20.02292,20.02292,0,0,1,20,20v44Z"
        ) + additionalProps
    )
} 