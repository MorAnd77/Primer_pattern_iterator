import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToDoList implements Iterable<String> {

    private List<String> primary = new ArrayList<>();
    private List<String> secondary = new ArrayList<>();

    public ToDoList addPrimary(String task) {
        primary.add(task);
        return this;
    }

    public ToDoList addSecondary(String task) {
        secondary.add(task);
        return this;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            boolean isPrimary = true;
            int next = 0;

            @Override
            public boolean hasNext() {
                if (isPrimary) {
                    if (next < primary.size())
                        return true;
                    else
                        return !secondary.isEmpty();
                } else {
                    return next < secondary.size();
                }
            }

            @Override
            public String next() {
                if (isPrimary) {
                    if (next < primary.size()) {
                        String result = primary.get(next);
                        next++;
                        return result;
                    }
                    else {
                        isPrimary = false;
                        next = 0;
                        String result = secondary.get(0);
                        next++;
                        return result;
                    }
                } else {
                    if (next < secondary.size()) {
                        String result = secondary.get(next);
                        next++;
                        return result;
                    } else throw new RuntimeException("Вы попытались получит не существующий элемент");
                }
            }
        };
    }
}
