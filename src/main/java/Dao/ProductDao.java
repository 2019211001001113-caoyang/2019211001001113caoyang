package Dao;

import com.caoyang.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String queryString = "select * from  where productId=?";
        PreparedStatement pt = con. prepareStatement(queryString);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setProductId(rs.getInt(  "ProductId" ));
            product.setProductName(rs.getString("ProductNane"));
            product.setProductDescription(rs.getString("ProductDescription");
            product.setPrice(rs.getDouble( "Priee"));
            product.setCategoryId(rs . getInt( "CategoryI0"));
            list.add(product);
        }
        return Product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        return null;
    }

    List<Product> list=new ArrayList<Product>();
    String queryString = "select * from  where categoryId=?";
    PreparedStatement pt = con. prepareStatement(queryString);
        pt.setInt(1,categoryId);
    ResultSet rs = pt.executeQuery();
        while (rs.next()) {
        Product product = new Product();
        product.setProductId(rs.getInt(  "ProductId" ));
        product.setProductName(rs.getString("ProductNane"));
        product.setProductDescription(rs.getString("ProductDescription");
        product.setPrice(rs.getDouble( "Priee"));
        product.setCategoryId(rs . getInt( "CategoryI0"));
        list.add(product);
    }
    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String queryString = "select * from  where categoryId=?";
        PreparedStatement pt = con. prepareStatement(queryString);
        pt.setInt(1,categoryId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt(  "ProductId" ));
            product.setProductName(rs.getString("ProductNane"));
            product.setProductDescription(rs.getString("ProductDescription");
            product.setPrice(rs.getDouble( "Priee"));
                    product.setCategoryId(rs . getInt( "CategoryI0"));
                            list.add(product);
        }
            System.out.println("successful");
            return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imgByte=null;
        String sql ="seLect picture from product where productId=?" ;
        PreparedStatement pt=con.prepareStatement (sql) ;
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("picture");
            byte[] imgBytes = blob.getBytes(1, (int) blob.length());
        }
        byte[] imgBytes;
        return  imgBytes;


}
