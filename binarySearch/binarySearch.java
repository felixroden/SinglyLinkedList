    public static int binarySearch(int[] haystack, int needle) {

        int high = haystack.length - 1;
        int low = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int value = haystack[mid];

            if(value == needle) {
                return mid;
            } else if (value >needle) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
