package repository;

import databaseAccess.DerbyConnection;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> implements ParseInterface {
    protected List<T> lijst = new ArrayList<>();

    { setRepository(); }

    protected ArrayList<T> setList(String query) {
        List<String[]> dataSet = DerbyConnection.getRows(query);
        ArrayList<T> lijst = new ArrayList<>();

        if (dataSet != null) {
            dataSet.forEach(rij -> lijst.add(mapToModel(rij)));
        }
        return lijst;
    }

    abstract void setRepository();

    public List<T> getAll() {
        setRepository();
        return lijst;
    }

    abstract T mapToModel(String[] rij);
}
