
package model.dao;

import controller.DataSource;
import model.container.List;

public abstract class Dao<T extends Dto> 
{

    private final DataSource dataSource;

    protected Dao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public boolean insert(Dto data)
    {
        return dataSource.runUpdateQuery(data.insert());
    }

    public abstract List<T> read();

    public boolean update(Dto data) 
    {
        return dataSource.runUpdateQuery(data.update());
    }

    public boolean delete(Dto data) 
    {
        return dataSource.runUpdateQuery(data.delete());
    }

    public abstract Object findByPlaca(Dto data);

}
