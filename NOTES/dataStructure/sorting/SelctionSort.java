package dataStructure.sorting;

import java.util.Arrays;

public class SelctionSort {
    /**
     * 선택정렬
     * 시간복잡도 O(N^2)
     * <a href="https://www.youtube.com/watch?v=uCUu3fF5Dws">...</a>
     */

    /*
    정렬 안 된 배열방 중 가장 작은 애를 찾아서 맨 앞으로 보내주는 것 반복
     */

    // 함수를 선언하고 정렬할 배열을 인자로 받습니다.
    private static void selectionSort(int[] arr) {
        // 재귀함수를 호출하는데요
        // 정렬이 안 된 부분의 시작 위치를 같이 넘깁니다
        selectionSort(arr, 0);
    }

    // 재귀함수가 호출되면 배열과 시작점을 인자로 받고
    private static void selectionSort(int[] arr, int start) {
        // 시작점이 배열의 마지막 방보다 작은 동안 재귀함수를 호출합니다.
        if(start < arr.length - 1) {
            // 가장 작은 방의 인덱스를 저장할 변수 선언.
            // 초기값은 시작 인덱스
            int min_index = start;
            // 시작점부터 배열의 마지막 방까지 돌면서
            for(int i = start; i < arr.length ; i++) {
                // 해당 배열방의 값이 작은 값이라고 생각했던 것보다 더 작으면
                // 작은 방의 인덱스를 해당 배열방의 인덱스로 업데이트 해줍니다.
                if(arr[i] < arr[min_index]) min_index = i;
            }
            // 이렇게 배열방을 끝까지 돌면서 찾은 min_index를 swap 함수를 호출해서 맨 앞에 애랑 맞바꿉니다.
            swap(arr, start, min_index);
            // 이제 맨 앞에 애는 정렬이 된 거니까 시작점 하나 증가시켜서 함수 다시 호출
            selectionSort(arr, start+1);
        }
    }

    // 두 개의 인덱스를 받아서 값을 swap 하는 함수 하나 정의
    private static void swap (int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
