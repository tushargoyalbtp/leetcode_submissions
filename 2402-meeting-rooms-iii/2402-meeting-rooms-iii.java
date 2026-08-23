class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap: available room numbers
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Min heap: {endTime, roomNumber}
        // Sort by endTime, then roomNumber
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        // Initially all rooms are available
        for (int room = 0; room < n; room++) {
            availableRooms.offer(room);
        }

        int[] count = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms whose meetings have ended
            while (!busyRooms.isEmpty()
                    && busyRooms.peek()[0] <= start) {

                long[] roomInfo = busyRooms.poll();
                int room = (int) roomInfo[1];

                availableRooms.offer(room);
            }

            // If a room is available
            if (!availableRooms.isEmpty()) {

                // Always choose the smallest room number
                int room = availableRooms.poll();

                busyRooms.offer(new long[]{end, room});

                count[room]++;

            } else {

                // No room available.
                // Choose the room that becomes free earliest.
                long[] roomInfo = busyRooms.poll();

                long earliestEnd = roomInfo[0];
                int room = (int) roomInfo[1];

                // Delay the meeting
                long newEnd = earliestEnd + duration;

                busyRooms.offer(new long[]{newEnd, room});

                count[room]++;
            }
        }

        // Find the room with maximum usage.
        // Smaller room wins in case of tie.
        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (count[room] > count[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}


        // Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // long[] listAvailableRooms = new long[n];
        // int[] roomUsedCount = new int[n];

        // for (int[] meeting : meetings) {
        //     int start = meeting[0];
        //     int end = meeting[1];

        //     int duration = end - start;
        //     boolean found = false;

        //     long earlyEndRoomTime = Long.MAX_VALUE;
        //     int earlyEndRoom = 0;

        //     for (int room = 0; room < n; room++) {

        //         if (listAvailableRooms[room] <= start) {
        //             listAvailableRooms[room] = end;
        //             roomUsedCount[room]++;
        //             found = true;
        //             break;
        //         }

        //         if (listAvailableRooms[room] < earlyEndRoomTime) {
        //             earlyEndRoomTime = listAvailableRooms[room];
        //             earlyEndRoom = room;
        //         }
        //     }

        //     if (!found) {
        //         listAvailableRooms[earlyEndRoom] += duration;
        //         roomUsedCount[earlyEndRoom]++;
        //     }
        // }

        // int resultRoom = -1;
        // int maxUse = 0;

        // for (int room = 0; room < n; room++) {
        //     if (roomUsedCount[room] > maxUse) {
        //         maxUse = roomUsedCount[room];
        //         resultRoom = room;
        //     }
        // }

        // return resultRoom;
//     }
// }