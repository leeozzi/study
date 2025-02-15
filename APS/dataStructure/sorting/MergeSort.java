package dataStructure.sorting;

import java.util.Arrays;

public class MergeSort {
    /** 병합 정렬
     * <a href="https://www.youtube.com/watch?v=QAyl79dCO_k">...</a>
     */

    /*
    1. 배열을 둘로 나눈다
    2. 나눈 배열을 또 반씩 나눈다
    -> 배열방에 두 개씩 남았을 때부터 merge sort를 할 수 있다
    3. 방의 개수가 하나인 두 개의 배열이라고 생각하고,
       새로운 빈 배열에 작은 수를 먼저 넣어주고 남은 수를 넣어준다
       -> 정렬이 된 배열이 되었으므로 배열에 복사한다
    4. 3의 과정을 반복하여 정렬이 된 2칸의 배열방을 여러 개 만든다
    5. 2칸의 배열방들을 또 2개씩 병합한다.
       이런 식으로 계속 병합해 나감

     시간 복잡도 O(n log n)
     - 실행 시 별도의 저장 공간을 필요하기 때문에 공간을 사용할 수 없는 경우에는 Quick Sort 사용
     */

    /// ///////////////////////////////////////////////////

    // 정렬할 배열을 인자로 받는 mergeSort 함수
    private static void mergeSort(int[] arr) {
        // 임시 저장 공간 필요. 배열의 크기만큼 만들어줌
        int[] tmp = new int[arr.length];

        // 원본 배열, 임시 저장소, 시작과 끝 인덱스를 넘겨줘서 재귀함수 호출
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {   // 시작 인덱스가 끝 인덱스보다 작은 동안만 재귀호출
            int mid = (start + end) / 2;    // 물리적으로 딱 가운데를 잘라야 하므로 가운데 인덱스 필요
            mergeSort(arr, tmp, start, mid);    // 배열의 앞부분. start ~ 가운데까지
            mergeSort(arr, tmp, mid + 1, end);  // 배열의 뒷부분. 가운데 바로 뒤 ~ end까지
            merge(arr, tmp, start, mid, end);   // 두 개로 나누어진 배열방을 합쳐줄 함수
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        // 우선, 임시 저장소에 정렬이 된 배열을 필요한 만큼 복사해준다.
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;

        // 양쪽 배열방에서 작은 값을 하나씩 복사할 때마다
        // 결과 배열방의 어디에 저장해야하는지 알아야 하니까
        // 복사 후에 하나씩 늘려줘서 다음에 저장할 곳을 기억
        int index = start;

        while (part1 <= mid && part2 <= end) {   // 첫 번째 배열이 끝까지 가거나 두 번째 배열이 끝까지 갈 때까지 반복문
            // 두 배열방의 첫 번째 값부터 비교해서 
            // 앞에 게 작으면 앞에 걸 옮기고 앞쪽 포인터를 하나 뒤로 옮긴다
            // 뒤에 게 작으면 뒤에 걸 옮기고 뒤쪽 포인터를 하나 앞으로 옮긴다
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            // 어느쪽 배열을 옮겼든지 간에 인덱스는 하나 늘려줘야 해
            index++;
        }   // 이렇게 계속 돌리면 양쪽 중 하나가 끝날 때까지 돌겠죠?

        // 그런데 만약 뒤쪽은 비었고 앞쪽에는 데이터가 남아있는 경우를 대비해서
        // 앞쪽 포인터가 배열의 끝에서 남은 만큼을 돌면서 최종적으로 저장할 배열에 남은 값들을 붙여줍니다.
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

        // 만약 앞쪽 배열은 비어있고, 뒤쪽 배열에 데이터가 남아있는 경우는?
        // 뒤쪽 배열은 최종 배열의 뒤쪽에 이미 자리하고 있기 때문에
        // 뒤쪽에 남은 데이터는 신경 안 쓰고 놔두면 됨 !
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
