## HashMap 순회 방법
### 1. 반복자(Iterator) 및 entrySet() 메서드
Map 인터페이스는 Collection 인터페이스를 상속하지 않았으므로 반복자(Iterator)가 존재하지 않는다.  
entrySet() 메서드는 Colletion 인터페이스를 상속하는 Set 인터페이스를 반환한다.  
반환된 Set 인터페이스에서 Iterator() 메서드를 사용하면 반복자를 사용할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>());

    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");

    Iterator<Map.Entry<String, String>> entry =
        hm.entrySet().iterator();
    
    while(entry.hasNext()) {
        Map.Entry<String, String> element = entry.next();
    
        System.out.println("KEY : " + element.getKey() + " / VALUE : " + element.getValue());
    }
```

### 2. 반복자(Iterator) 및 keySet() 메서드
HashMap의 keySet() 메서드는 키를 Set으로 반환한다.  
Set 인터페이스에는 반복자가 존재하므로 키를 순회할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    Iterator keySetIterator = hm.keySet().iterator();
    
    while(keySetIterator.hasNext()) {
        String key = keySetIterator.next().toString();
        
        System.out.println("KEY : " + key + " / VALUE : " + hm.get(key));
    }
```

### 3. 향상된 for문 및 entrySet() 메서드  
반복자를 직접 생성하지 않고 향상된 for문 내부적으로 iterator() 메서드를 호출할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    Set<Map.Entry<String, String>> entrySet = hm.entrySet();
    
    for(Map.Entry<String, String> element : entrySet) {
        System.out.println("KEY : " + element.getKey() + " / VALUE : " + element.getValue());
    }
    
```

### 4. 향상된 for문 및 keySet() 메서드
반복자를 지기접 생성하지 않고 향상된 for문 내부적으로 iterator() 메서드를 호출할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    Set<Map.Entry<String, String>> keySet = hm.keySet();
    
    for(String key : keySet) {
        System.out.println("KEY : " + key + " / VALUE : " + hm.get(key));
    }
    
```

### 5. forEach()문 및 람다식
HashMap의 forEach() 메서드는 BiConsumer 기능적 인터페이스를 인수로 사용하는 람다식을 사용할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    hm.forEach((key, value) -> {
        System.out.println("KEY : " + key + " / VALUE : " + value);
    });
```
위 예제는 다음처럼 Consumer 기능적 인터페이스를 인수로 사용하는 람다식으로 변경할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    hm.entrySet().forEach((entry) -> {
        System.out.println("KEY : " + entry.getKey() + " / VALUE : " + entry.getValue());
    });
```

### 6. Iterator.forEachRemaining() 메서드
Java 8 Version 이상인 경우 Iterator 인터페이스에 추가된 forEachRemaining() 메서드를 사용할 수 있다.
```
    HashMap<String, String> hm = new HashMap<String, String>();
    
    hm.put("A", "One");
    hm.put("B", "Two");
    hm.put("C", "Three");
    
    hm.entrySet().iterator().forEachRemaining((entry) -> {
        System.out.println("KEY : " + entry.getKey() + " / VALUE : " + entry.getValue());
    });
```


---
### 참고
[[Java]HashMap 순회하는 방법](https://developer-talk.tistory.com/520)