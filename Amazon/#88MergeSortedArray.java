    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a1 = m-1;
        int a2 = n-1;
        int k = m+n -1;
        while(a1>=0 && a2>=0){
            if(nums1[a1] < nums2[a2]){
                nums1[k--] = nums2[a2--];
            }else{
                nums1[k--] = nums1[a1--];
            }
        }
        while(a2 >=0){
            nums1[k--] = nums2[a2--];
        }
        
    }
