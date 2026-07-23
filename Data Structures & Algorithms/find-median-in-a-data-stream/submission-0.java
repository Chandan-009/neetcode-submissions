public  class MedianFinder {

        PriorityQueue<Integer> min_heap;
        PriorityQueue<Integer> max_heap;

        public MedianFinder() {
            min_heap=new PriorityQueue<>((a,b)->b-a);
            max_heap=new PriorityQueue<>();
        }

        public void addNum(int num) {

            // insert into the heap
            if(min_heap.size()==0 || num <= min_heap.peek())
                min_heap.add(num);
            else
                max_heap.add(num);

            // shuffle the heap
            if(min_heap.size() - max_heap.size() >= 2)
                max_heap.add(min_heap.poll());
            else if(max_heap.size() - min_heap.size() >= 2)
                min_heap.add(max_heap.poll());

        }

        public double findMedian() {
            int size=min_heap.size() + max_heap.size();

            if(size==0)
                return 0;

            // if it is even
            double m=0;
            if(size%2==0){
                int f1=(min_heap.size()==0) ? 0: min_heap.peek();
                int f2=(max_heap.size()==0) ? 0: max_heap.peek();
                m=(f1+f2)/2.0;
            }
            else {
                // check if min heap is odd
                if(min_heap.size()!=0 && min_heap.size()>max_heap.size()){
                    m=min_heap.peek();
                }
                // check if max heap is odd
                else if(max_heap.size()!=0 && max_heap.size()>min_heap.size()){
                    m=max_heap.peek();
                }

            }
            return m;
        }




    }