package nom.lesha.webApp01.model;

/**
 * @author Alexey Levchhenko
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer shop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }
}
