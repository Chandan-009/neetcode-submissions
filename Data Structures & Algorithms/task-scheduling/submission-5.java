class Solution {
        public int leastInterval(char[] tasks, int n) {
            PriorityQueue<Task> pq=new PriorityQueue<>();
            List<Character> res_list=new ArrayList<>();
            Queue<Task> q=new LinkedList<>();
            int current_index=0;
            
            // insert in hashmap
            HashMap<Character,Integer> map=new HashMap<>();
            for(char c:tasks){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            

            // push values to the heap
            for(char key: map.keySet()){
                Task t=new Task(key,-1,map.get(key));
                pq.add(t);
            }

            System.out.println(pq.toString());

            while(pq.size()>0 || q.size()>0) {
                char c='N';
                // check queue
                if(q.size()>0 && (q.peek().process_index==current_index)){
                    pq.add(q.poll());
                }
                // check heap
                if(pq.size()>0){
                    // pop it 
                    Task cur_task=pq.poll();
                    //System.out.println(cur_task);
                    // add it to the result 
                    c=cur_task.name;
                    // reduce the frequency
                    cur_task.frequnecy=cur_task.frequnecy-1;
                    // update the next index
                    cur_task.process_index=current_index+n+1;
                    // add it to the queue
                    //System.out.println(cur_task);
                    if(cur_task.frequnecy!=0)
                        q.add(cur_task);       
                }
                res_list.add(c);
                current_index++;
            }
             //System.out.println(res_list.toString());
            return   res_list.size();
        }

        class Task implements Comparable<Task> {
            char name;
            int process_index=-1;
            int frequnecy;
            Task(char name,int process_index, int frequnecy){
                this.name=name;
                this.process_index=process_index;
                this.frequnecy=frequnecy;
            }

            @Override
            public int compareTo(Task o) {
                return o.frequnecy-this.frequnecy;
            }

            public String toString(){
                return this.name+" "+this.process_index+" "+this.frequnecy;
            }

        }
    }