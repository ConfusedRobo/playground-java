package UdemyJavaMasterClass;

import java.util.List;

public interface Saveable {

    void saveInfo(int health, int ammo);
    List<String> getInfo();

}
