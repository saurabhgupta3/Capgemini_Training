public class CarDriver {
    public static void main(String[] args) {
        Car c2 = new Car("Kia", "Seltos");
        System.out.println(c2.getBrand());
        System.out.println(c2.getModel());
        System.out.println(c2.getE2().getHp());

        System.out.println("-------------------");
        Car c1 = new Car();
        c1.setBrand("Toyota");
        c1.setModel("Inova");
        c1.getE2().setHp(2000);

        System.out.println(c1.getBrand());
        System.out.println(c1.getModel());
        System.out.println(c1.getE2().getHp());
    }
}