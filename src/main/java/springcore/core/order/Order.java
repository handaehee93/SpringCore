package springcore.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    public Order(Long memberId, String itemName, int itemPrice, int
            discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }
    public Long getMemberId() {
        return memberId;
    }
    public String getItemName() {
        return itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }

    // toString메서드를 넣으면 해당 객체를 출력할 때 아래와 같이 결과를 받을 수 있다.
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
