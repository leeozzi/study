package dataStructure.sorting;

import java.util.Arrays;

public class QuickSorting {
    /**
     * 퀵 정렬
     * <a href="https://www.youtube.com/watch?v=7BDzle2n47c">...</a>
     */

     /*
     * 시간복잡도
     * 최악의 경우 O(N^2) 까지 갈 수도 있지만
     * 그럴 확률이 너무 낮아서 대체로 O(NlogN)라고 함
     */

     /*
        기준값을 선택한 후 기준값보다 작으면 왼쪽으로, 큰값을 오른쪽으로 이동시키는 방법
        현재 pivot = 5라고 가정
        배열의 양끝에 start와 end 포인터 한 개씩 가리킴
        start는 pivot 값보다 작은값들을 무시하면서 계속 뒤로 가고
        end는 pivot 값보다 큰 값들을 무시하면서 계속 앞으로 갈 거야
        그러다가 둘이 만나고, 지나치면 작은 값들과 큰 값으로 나뉘게 되는 것
        두 포인터가 엇갈리는 순간 반복문 끝남
        -------------------여기까지가 함수 한 번 끝
        방금 함수에서 start가 끝난 부분이 왼쪽 파티션의 끝이 되고,
        end가 끝난 부분이 오른쪽 파티션의 시작점이 돼서

        파티션 안에 있는 배열방이 2개 이상일 때
            -> 정렬 시작
    */


    // 정렬할 배열을 인자로 받는 퀵정렬 함수
    private static void quickSort(int[] arr) {
        // 정렬할 배열과, 시작지점, 끝나는지점을 받아서 본격적으로 재귀함수 호출
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 재귀함수가 호출되면 배열의 포인터와 스타트 엔드 파티션을 나눌 range를 인자로 받음
        // 해당 배열방의 시작과 끝 그 영역 안에서 파티션을 나누고,
        // 나눈 파티션의 오른쪽방 첫번째 값을 part2 로 받아옵니다
        int part2 = partition(arr, start, end);

        // 오른쪽 파티션이 시작점 바로 다음에서 시작한다면, 왼쪽 파티션의 데이터가 하나뿐이니까 정렬할 필요 없음
        if (start < part2 - 1) {   // 오른쪽 파티션이 시작점에서 한 개 이상 차이가 날 때만 재귀함수 호출
            // 지금 이건 왼쪽 파티션이니까 시작점은 똑같고 끝나는 점은 오른쪽 파티션의 시작점 바로 전으로
            quickSort(arr, start, part2 - 1);
        }

        // 그리고 오른쪽 파티션이 한 개 이상일 때만 호출해야 하니까
        if (part2 < end) {     // 오른쪽 파티션의 시작점이 마지막 배열방보다 작은 경우에만 오른쪽 파티션 정렬
            quickSort(arr, part2, end);
        }
    }

    // 배열방의 파티션을 나누는 함수
    // 인자로는 배열의 주소와, 파티션을 나눌 시작과 끝값 받음
    private static int partition(int[] arr, int start, int end) {
        // pivot 값은 배열방의 중간에 있는 값으로 한다
        int pivot = arr[(start + end) / 2];
        // 시작점이 끝지점보다 작거나 같은 동안만 양쪽 포인터를 옮겨줄 거야
        while (start <= end) {
            // start 포인터부터
            // 배열방의 값이 pivot 값보다 작으면 무시하고 넘어갈 거야
            while (arr[start] < pivot) start++;    // 배열방의 값이 pivot 값보다 크거나 같으면 그 자리에 멈춤
            while (arr[end] > pivot) end--;
            // 두 포인터가 멈춘 다음에
            if(start <= end) {    // 혹시 서로를 지나치진 않았는지 한 번 확인해주고
                // 아직 안 지나쳤으니까
                swap(arr, start, end) ; // 두 개의 값을 swap 해줍니다
                // 그리고 포인터들을 각각 한 칸씩 이동시킵니다
                start++;
                end--;
            }
        } // 이걸 두 개의 값이 만나서 지나칠 때까지 반복하면 start 포인터에 새로 나눌 배열방의 첫 번째 인덱스가 들어가게 돼요

        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 5, 6 , 1, 7, 2, 0, 4, 8, 2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}