package hello.core;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HelloLombok {
    private String name;
    private int price;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("brian");
        String name=helloLombok.getName();
        System.out.println(name);
    }
}