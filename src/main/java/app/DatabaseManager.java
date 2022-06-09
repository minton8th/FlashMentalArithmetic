package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = connectionManager.getConnection();

	// データベースにデータを追加する関数
	public void insert(int value) {
		try {
			PreparedStatement preparedStatement = null;
			try {
				// SQLの定義
				String sql = "INSERT INTO VALUES (value) VALUES (?)";
				// SQLの作成(準備)
				preparedStatement = connection.prepareStatement(sql);
				// SQLバインド変数への値設定
				preparedStatement.setInt(1, value);
				// SQLの実行
				int result = preparedStatement.executeUpdate();
				System.out.println("登録結果:" + result);
				connectionManager.commit();
			} catch (Exception e) {
				connectionManager.rollback();
				throw new RuntimeException("INSERTに失敗しました", e);
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
						System.out.println("ステートメントの解放に成功しました");
					}
				} catch (SQLException e) {
					throw new RuntimeException("ステートメントの解放に失敗しました", e);
				}
			}
		} finally {
			connectionManager.closeConnection();
		}
	}

	// データベースからデータを取得する関数
	public List<Integer> select() {
		PreparedStatement preparedStatement = null;
		List<Integer> valueList = new ArrayList<Integer>();
		try {
			// SQLの定義
			String sql = "SELECT value FROM VALUES";
			// SQLの作成(準備)
			preparedStatement = connection.prepareStatement(sql);
			// SQLの実行
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int value = resultSet.getInt("value");
				System.out.println(value);
				valueList.add(value);
			}
			return valueList;
		} catch (Exception e) {
			throw new RuntimeException("SELECTに失敗しました", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					System.out.println("ステートメントの解放に成功しました");
				}
			} catch (SQLException e) {
				throw new RuntimeException("ステートメントの解放に失敗しました", e);
			}
		}
	}

	// データベースのテーブルの値をリセットする関数
	public void delete() {
		PreparedStatement preparedStatement = null;
		try {
			// SQLの定義
			String sql = "DELETE FROM VALUES";
			// SQLの作成(準備)
			preparedStatement = connection.prepareStatement(sql);
			// SQLの実行
			preparedStatement.executeUpdate();
			connectionManager.commit();
		} catch (Exception e) {
			connectionManager.rollback();
			throw new RuntimeException("DELETEに失敗しました", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					System.out.println("ステートメントの解放に成功しました");
				}
			} catch (SQLException e) {
				throw new RuntimeException("ステートメントの解放に失敗しました", e);
			}
		}
	}

}
