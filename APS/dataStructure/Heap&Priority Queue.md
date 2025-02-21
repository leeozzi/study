
# Heap
- 완전 이진 트리의 일종으로, 우선순위 큐를 위하여 만들어진 자료구조
- 여러 개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아냄

- 반정렬 상태(느슨한 정렬 상태) 유지
  : 부모 노드의 키 값이 자식 노드의 키 값보다 항상 크거나 작은 이진 트리

- 힙 트리에서는 중복값 허용 O, 이진 탐색 트리에서는 중복값 허용 X

- 힙을 저장하는 표준 자료구조는 배열이다. 보통 0번째 인덱스는 사용하지 않는다.
- 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.  
  ex) 루트 노드의 오른쪽 노드 번호는 항상 3이다.
- 왼쪽 자식의 인덱스 = 부모인덱스 * 2
  오른쪽 자식의 인덱스 = 부모인덱스*2 + 1
  부모인덱스 = 자식인덱스/2


## 종류
### 최대 힙
- 키 값이 가장 큰 노드를 찾기 위한 완전 이진 트리
- 부모 노드의 키 값 > 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 큰 노드


### 최소 힙
- 키 값이 가장 작은 노드를 찾기 위한 완전 이진 트리
- 부모 노드의 키 값 <= 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 작은 노드
  
<br>

## 삽입, 삭제, 조회
### 삽입 방법
  1. 새 요소를 트리(배열)의 끝에 삽입
  2. 부모 노드 < 삽입 노드면 서로 교환   
      => 이 과정을 부모 노드가 더 클 때까지 반복
  - 시간 복잡도 O(logN)


### 삭제 방법 (최대 힙으로 예시)
  - 최대 힙에서 삭제 연산은 최댓값을 가진 요소를 삭제하는 것이다
  1. 최댓값인 루트노드를 삭제 
  2. 마지막 노드를 루트로 이동
  3. 방금 루트로 이동해준 노드와 자식 노드를 비교, 자식 노드 중 더 큰 값과 교환   
      => 이 과정을 자식 노드가 둘 다 자기보다 더 작을 때까지 반복
   - 시간 복잡도 O(logN)

<br>

## 힙 구현 (Max Heap 기준)
### 힙 삽입
```
Insert(heap, value)
  1. heap.size <- heap.size + 1
  2. heap[heap.size] = value  // 새 요소를 배열 끝에 삽입
  3. idx = heap.size  // 삽입한 요소의 인덱스

  4. while (idx > 1 && heap[parent(i)] < heap[i])
      swap(heap[i], heap[parent(i)]) // 부모 노드와 교환
      idx = parent(i)  // 인덱스를 부모로 이동
     End while
```


### 힙 삭제
```
Delete(heap)
  1. if (heap.size == 0)
      return "힙이 비었습니다"
  2. maxValue = heap[1] // 루트(최댓값) 저장
  3. heap[1] = heap[heap.size]  // 마지막 요소를 루트로 이동
  4. heap.size -- // 힙 크기 감소
  
  5. i = 1  // 루트 인덱스
  6. while left(i) <= heap.size
        largerChild = left(i)

        if (right(i) <= heap.size && heap[right(i)] > heap[left(i)])
            largerChild = right

        if (heap[i] >= heap[largerChild])
            break;

        Swap(heap[i], heap[largerChild])  //  자식 노드와 교환
        i = largerChild // 인덱스를 자식으로 이동

     End while

     return maxValue  //  삭제한 최댓값 반환
      
```

<br>

## 우선순위 큐
- 들어오는 순서와 상관없이 우선순위가 높은 데이터가 먼저 나가는 구조
- 배열을 이용한 구현, 연결리스트를 이용한 구현, Heap 자료구조를 이용한 구현
- java.util.PriorityQueue 활용
- Priority Queue에서 우선순위 기준을 정의할 때는 Compare 메서드를 Override 해주면 된다

```
// example
public int compare(Student o1, Student o2) {
    if (o1.mathScore == o2.mathScore) {
        return o2.engScore - o1.engScore;
    } else {
        return o1.mathScore - o2.mathScore;
    }
}
```


<br>

## 힙 정렬
- 힙 자료구조를 활용한 비교 기반 정렬 알고리즘
  1. 정렬하고 싶은 모든 요소를 힙에 삽입 (반복)
  2. 힙에서 순차적으로 값을 삭제하여 출력
- 중간에 값을 다시 넣었다가 빼면 정렬이 틀어질 수 있음
- 시간복잡도 O(NlogN)