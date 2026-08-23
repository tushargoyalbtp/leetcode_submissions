class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int m = meetings.length;

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long[] listAvailableRooms = new long[n];
        int[] roomUsedCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            int duration = end - start;
            boolean found = false;

            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            for (int room = 0; room < n; room++) {

                if (listAvailableRooms[room] <= start) {
                    listAvailableRooms[room] = end;
                    roomUsedCount[room]++;
                    found = true;
                    break;
                }

                if (listAvailableRooms[room] < earlyEndRoomTime) {
                    earlyEndRoomTime = listAvailableRooms[room];
                    earlyEndRoom = room;
                }
            }

            if (!found) {
                listAvailableRooms[earlyEndRoom] += duration;
                roomUsedCount[earlyEndRoom]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;

        for (int room = 0; room < n; room++) {
            if (roomUsedCount[room] > maxUse) {
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}