# Comparable과 Comparator
Comparable과 Comparator는 모두 **인터페이스**이다.
-> 메소드 구현해야 함  
- Comparable 인터페이스 -> compareTo(T o)
- Comparator 인터페이스 -> compare(T o1, T o2)

## Comparable과 Comparator의 역할
객체를 비교할 수 있도록 한다.   

객체는 사용자가 기준을 정해주지 않으면 객체의 우선순위를 판단할 수 없다.  


## Comparable과 Comparator의 차이점
### 1. 비교 대상 
- Comparable : 자기 자신과 매개변수 객체를 비교
- Comparator : 두 매개변수 객체를 비교

### 2. 속한 패키지
- Comparable : lang 패키지에 포함
- Comparator : util 패키지에 포함


> ⭐ heap이랑 PQ 배울 때 Heap03_PersonPQ1 에서는 Person 클래스에 **Comparable<Person>**을 상속받고 compareTo로 **각 객체마다 우선순위를 부여**해줬으므로 PriorityQueue 객체 만들 때는 그냥 new PriorityQueue<>() 해주면 됐음 !!  
>
>긍까, 예를 들면 우리가 Priority에 1이랑 3을 넣었어. 그럼 우리가 1이랑 3의 순서를 정해주지 않았지만 자체적인 크기(1은 1, 3은 3)에 따라서 비교해주잖아. 그런 거임. 객체한테 자체적인 크기를 부여해주는 거지.
>
> 반면에, Heap04_PersonPQ2에서는 Person 클래스에 아무것도 상속해주지 않았어. 그러니까 **객체의 자체적인 크기가 없어**. 그래서 PriorityQueue 만들 때 **Comparator** 따로 만들어주고 compare 함수 override 해서 기준을 세워준 거야. PQ한테 이 기준대로 정렬해줘~ 하는 거지.


## 사용법
### Comparable
> - 자기 자신과 매개변수 객체 비교 !  
> - compareTo(T o) 구현 

비교할 대상의 자료형을 제네릭으로 받아서 implement
```
class Student implements Comparable<Student>
```

compareTo 메서드 구현  
- int형 반환하게 되어 있음! 값 비교해서 정수 반환.  
- String은 내부적으로 compareTo 구현되어 있음.

```
// 정석적인 방법
@Override
public int compareTo(Student o){
    // 자기 자신의 age가 o보다 크다면 양수
    if(this.age > o.age) return 1;
    // 같다면 0
    else if (this.age == o.age) return 0;
    // 자기 자신의 age가 o보다 작다면 음수
    else return -1;
}
```
```
// 간편한 방법
// ⚠️ 뺄셈 과정에서 자료형의 범위를 넘지 않는지 확인할 것 !!!
@Override
public int compareTo(Student o){
    // 자기 자신의 age가 o보다 크다면 양수
    // 같다면 0
    // 자기 자신의 age가 o보다 작다면 음수
    return this.age - o.age;
}
```


### Comparator
> - 두 매개변수 객체를 비교
> - compare(T o1, T o2) 구현

비교할 대상들의 자료형을 제네릭으로 받아서 implement
```
class Student implements Comparator<Student>
```

PQ 만들 때는 PQ 만들면서 Comparator 생성해줘도 OK
```
PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // 나이순
                if (o1.age != o2.age) {
                    return o2.age - o1.age;
                }

                // 나이가 같다면 이름순으로
                else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
```

