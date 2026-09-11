class TreeNode{
    TreeNode left;
    TreeNode right;
    int start;
    int end;
    TreeNode(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class MyCalendar {
    TreeNode root;
    public MyCalendar() {
        root = null;
    }
    
    public boolean book(int startTime, int endTime) {
        if(root == null){
            root = new TreeNode(startTime, endTime);
            return true;
        }
        else{
            return insert(root,startTime , endTime);
        }
        
    }
}

public boolean insert(TreeNode curr, int startTime , int endTime){
    if(startTime >= curr.end){
        if(curr.right == null){
            curr.right = new TreeNode(startTime,endTime);
            return true;
        }

        return insert(curr.right , startTime , endTime);
    }

    if(endTime <= curr.start){
        if(curr.left == null){
            curr.left = new TreeNode(startTime, endTime);
            return true;
        }

        return insert(curr.left , startTime, endTime);
    }

    return false;
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */