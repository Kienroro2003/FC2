import java.util.List;

public class ManageMaterial {
    List<Material> materialList;
    WriteAndRead writeAndRead = new WriteAndRead();

    public ManageMaterial() {
        materialList = writeAndRead.readFile();
    }

    public void display() {
        for (Material m : materialList) {
            System.out.println(m);
        }
    }

    public int findMaterial(String name) {
        int total = 0;
        for (Material m : materialList) {
            if (m.getName().split(" ")[0].equals(name)) {
                total += m.getCount();
            }
        }
        return total;
    }

    public long task4(String name, int count){
        for(Material m : materialList){
            if(m.getName().equals(name) && m.getCount() >= count){
                return m.getCount() * m.getPrice();
            }
        }
        return 0;
    }
}
