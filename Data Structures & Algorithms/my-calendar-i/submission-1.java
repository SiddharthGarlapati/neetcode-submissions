class MyCalendar {

    List<int[]> intervals; 

    public MyCalendar() {
        intervals = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] interval : intervals){
            if(startTime <  interval[1] && 
            endTime > interval[0]){
                return false;
            }
        }

        intervals.add(new int[]{startTime , endTime});

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */