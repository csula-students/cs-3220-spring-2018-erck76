package edu.csula.storage.mysql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Generator;

public class GeneratorsDAOImpl implements GeneratorsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "SELECT * FROM generators";
	protected static final String getByIdQuery = "SELECT * FROM generators WHERE id = ?";
	protected static final String setQuery = "UPDATE generators SET name=?, description=?, rate=?, base_cost=?, unlock_at=? WHERE id=?";
	protected static final String addQuery = "INSERT INTO generators VALUES (?, ?, ?, ?, ?, ?)";
	protected static final String removeQuery = "DELETE FROM generators WHERE id=?";

	public GeneratorsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Generator> getAll() {
		List<Generator> events = new ArrayList<>();
		try (Connection c = context.getConnection(); Statement stmt = c.createStatement())
    {
			ResultSet rs = stmt.executeQuery(getAllQuery);
      
			while (rs.next())
      {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				int rate = rs.getInt(4);
				int baseCost = rs.getInt(5);
				int unlockAt = rs.getInt(6);
        
				events.add(new Generator(id, name, description,rate,baseCost,unlockAt));
			}
		} catch (SQLException e)
    {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return events;
	}

	@Override
	public Optional<Generator> getById(int id) {
		try (Connection c = context.getConnection(); PreparedStatement  stmt = c.prepareStatement(getByIdQuery))
    {
			stmt.setInt(1, id);

			ResultSet rs =  stmt.executeQuery();
      
			if (rs.next())
      {
				int i = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				int rate = rs.getInt(4);
				int baseCost = rs.getInt(5);
				int unlockAt= rs.getInt(6);
        
				Generator generator = new Generator(id, name, desc, rate, baseCost, unlockAt);
        
				return Optional.of(generator);
			}

		} catch (SQLException e)
    {
			e.printStackTrace();
			Optional.empty();
		}
		return Optional.empty();
	}

	@Override
	public void set(int id, Generator generator) {
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(setQuery))
    {
			stmt.setInt(1, id);
			stmt.setString(2, generator.getName());
			stmt.setString(3, generator.getDescription());
			stmt.setInt(4, generator.getRate());
			stmt.setInt(5, generator.getBaseCost());
			stmt.setInt(6,generator.getUnlockAt());
			stmt.executeUpdate();
      
		} catch (SQLException e)
    {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Generator generator) {
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(addQuery))
    {
			stmt.setString(1, generator.getName());
			stmt.setString(2, generator.getDescription());
			stmt.setInt(3, generator.getRate());
			stmt.setInt(4, generator.getBaseCost());
			stmt.setInt(5, generator.getUnlockAt());
			stmt.executeUpdate();
      
		} catch (SQLException e)
    {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		try(Connection c = context.getConnection();PreparedStatement stmt = c.prepareStatement(removeQuery))
    {
			stmt.setInt(1, id);
			stmt.execute();
      
		} catch (SQLException e)
    {
			e.printStackTrace();
		} catch (Exception e)
    {
			e.printStackTrace();
		}
	}
}
