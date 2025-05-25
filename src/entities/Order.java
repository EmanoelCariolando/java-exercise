package entities;

import enums.entities.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private Client client;
    List<OrderItem> items = new ArrayList<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Client client,Date moment, OrderStatus status){
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append( sdf.format(moment) + "\n");
        sb.append("Order Status: ");
        sb.append( status + "\n");
        sb.append("Client: ");
        sb.append( client + "\n");
        sb.append("Order items:" + "\n");
        for(OrderItem i : items){
            sb.append(i).append("\n");
        }
        sb.append("Order total: $");
        sb.append(Total());
        return sb.toString();
    }

    public Double Total(){
        Double total = 0.0;
        for(OrderItem item : items){
            total += item.getTotal();
        }
        return total;
    }
}
