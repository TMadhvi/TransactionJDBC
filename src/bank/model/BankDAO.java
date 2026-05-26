package bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BankDAO {
	public List<account> read() {
		List<account> list = new LinkedList<>();

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareCall("select * from account");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new account(rs.getInt("id"), rs.getString("name"), rs.getString("accountNumber"),
						rs.getString("pin"), rs.getDouble("balance")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// insert

	public int insert(account ac) {
		int i = 0;

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con
					.prepareCall("insert into account (name, accountNumber,pin,balance) values (?,?,?,?)");
			pst.setString(1, ac.getName());
			pst.setString(2, ac.getAccountNumber());
			pst.setString(3, ac.getPin());
			pst.setDouble(4, ac.getBalance());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	// update
	public int update(account ac) {
		int i = 0;

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con
					.prepareCall("update account set name=?,accountNumber=?,pin=?,balance=? where id=? ");
			pst.setString(1, ac.getName());
			pst.setString(2, ac.getAccountNumber());
			pst.setString(3, ac.getPin());
			pst.setDouble(4, ac.getBalance());
			pst.setInt(5, ac.getId());

			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	// delete
	public int delete(int id) {
		int i = 0;

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareCall("delete from account where id=?");
			pst.setInt(1, id);

			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	// transaction
	public void transfer(double amount, int debitId, int creditId) {
		Connection con = DBUtil.makeConnection();
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;

		try {
			con.setAutoCommit(false);
			pst1 = con.prepareStatement("update account set balance=balance-? where id=?");
			pst1.setDouble(1, amount);
			pst1.setInt(2, debitId);

			pst2 = con.prepareStatement("update account set balance=balance+? where id=?");
			pst2.setDouble(1, amount);
			pst2.setInt(2, creditId);

			int i = pst1.executeUpdate();
			int j = pst2.executeUpdate();

			if (i != 0 && j != 0) {
				con.commit();
				System.out.println("Transaction succesfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void debit(double amount, int id) {

		Connection con = DBUtil.makeConnection();
		PreparedStatement pst1 = null;

		try {
			con.setAutoCommit(false);
			pst1 = con.prepareStatement("update account set balance=balance+? where id=?");
			pst1.setDouble(1, amount);
			pst1.setInt(2, id);

			int i = pst1.executeUpdate();

			if (i != 0) {
				con.commit();
				System.out.println("Debit successfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// credit
	public void credit(double amount, int id) {

		Connection con = DBUtil.makeConnection();
		PreparedStatement pst2 = null;

		try {
			con.setAutoCommit(false);
			pst2 = con.prepareStatement("update account set balance=balance-? where id=?");
			pst2.setDouble(1, amount);
			pst2.setInt(2, id);

			int i = pst2.executeUpdate();

			if (i != 0) {
				con.commit();
				System.out.println("Credit successfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
