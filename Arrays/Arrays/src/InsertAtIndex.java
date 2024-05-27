public class InsertAtIndex {


    public void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        if (index == sizeOfArray - 1) {
            arr[index] = element;
            return;
        }
        arr[sizeOfArray - 1] = -1;

        for (int i = sizeOfArray - 1; i > index; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        arr[index] = element;
    }


}
