public class MeanHeapImlp2 {
    class MinHeap {
        int[] harr;
        int capacity;
        int heap_size;

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        MinHeap(int cap) {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }

        //Function to insert a value in Heap.
        void insertKey(int k) {
            heap_size++;
            int i = heap_size - 1;
            //inserting the value at leaf node.
            harr[i] = k;

            while (i != 0 && harr[parent(i)] > harr[i]) {
                //swapping values of ith index with its parent node
                //if value at parent node is greater.
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }

        //Function to change value at ith index and store that value at first index.
        void decreaseKey(int i, int new_val) {
            //storing new value at ith index.
            harr[i] = new_val;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                //swapping values of ith index with its parent node
                //if value at parent node is greater.
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }

        //Function to extract minimum value in heap and then to store
        //next minimum value at first index.
        int extractMin() {
            if (heap_size <= 0) return -1;
            if (heap_size == 1) {
                heap_size--;
                return harr[0];
            }
            int root = harr[0];

            //storing value of leaf node at first index.
            harr[0] = harr[heap_size - 1];
            harr[heap_size - 1] = 0;
            heap_size--;

            //calling heapify function for the first index.
            MinHeapify(0);

            return root;
        }

        //Function to delete a key at ith index.
        void deleteKey(int i) {
            if (i < heap_size) {
                //decreasing value at ith index to minimum integer value.
                decreaseKey(i, Integer.MIN_VALUE);
                //extracting the minimum value from heap.
                extractMin();
            }
        }

        //MinHeapify function is used to heapify ith index.
        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            //if left or right child is smaller than current element,
            //we store its position.
            if (l < heap_size && harr[l] < harr[i])
                smallest = l;
            if (r < heap_size && harr[r] < harr[smallest])
                smallest = r;

            //if smallest is not equal to i, we swap the values at their position.
            if (smallest != i) {
                int temp = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = temp;

                //calling function recursively for the smallest index.
                MinHeapify(smallest);
            }
        }
    }
}
