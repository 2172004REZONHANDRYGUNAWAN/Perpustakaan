package com.example.librarymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Button bars_btn;

    @FXML
    private Button arrow_btn;

    @FXML
    private AnchorPane nav_form;

    @FXML
    private Circle circle_image;

    @FXML
    private Label studentNumber_label;

    @FXML
    private Button availableBooks_btn;

    @FXML
    private Button issueBooks_btn;

    @FXML
    private Button returnBooks_btn;

    @FXML
    private Button savedBooks_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane availableBooks_form;

    @FXML
    private TableView<availableBooks> availableBooks_tableView;

    @FXML
    private TableColumn<availableBooks, String> col_ab_bookTitle;

    @FXML
    private TableColumn<availableBooks, String> col_ab_author;

    @FXML
    private TableColumn<availableBooks, String> col_ab_bookType;

    @FXML
    private TableColumn<availableBooks, String> col_ab_publishedDate;

    @FXML
    private ImageView availableBooks_imageView;

    @FXML
    private Button save_btn;

    @FXML
    private Label availableBooks_title;

    @FXML
    private Button take_btn;

    @FXML
    private AnchorPane halfNav_form;

    @FXML
    private Circle smallCircle_image;

    @FXML
    private Button halfNav_availableBtn;

    @FXML
    private Button halfNav_takeBtn;

    @FXML
    private Button halfNav_returnBtn;

    @FXML
    private Button halfNav_saveBtn;

    @FXML
    private AnchorPane mainCenter_form;

    @FXML
    private AnchorPane issue_form;

    @FXML
    private AnchorPane returnBook_form;

    @FXML
    private AnchorPane savedBook_form;

    @FXML
    private Label currentForm_label;

    @FXML
    private Label take_StudentNumber;

    @FXML
    private TextField take_FirstName;

    @FXML
    private TextField take_LastName;

    @FXML
    private ComboBox<?> take_Gender;

    @FXML
    private TextField take_BookTitle;

    @FXML
    private Label take_IssuedDate;

    @FXML
    private ImageView take_imageView;

    @FXML
    private Label take_titleLabel;

    @FXML
    private Label take_authorLabel;

    @FXML
    private Label take_genreLabel;

    @FXML
    private Label take_dateLabel;

    @FXML
    private Button take_clearBtn;

    @FXML
    private Button take_takeBtn;

    @FXML
    private TableView<returnBook> return_tableView;

    @FXML
    private TableColumn<returnBook, String> col_return_BookTitle;

    @FXML
    private TableColumn<returnBook, String> col_return_Author;

    @FXML
    private TableColumn<returnBook, String> col_return_bookType;

    @FXML
    private TableColumn<returnBook, String> col_return_dateIssue;

    @FXML
    private ImageView return_imageView;

    @FXML
    private Button return_button;

    @FXML
    private Label returnBookTitle;

    @FXML
    private TableView<saveBook> save_tableView;

    @FXML
    private TableColumn<saveBook, String> col_saveTitle;

    @FXML
    private TableColumn<saveBook, String> col_saveAuthor;

    @FXML
    private TableColumn<saveBook, String> col_saveGenre;

    @FXML
    private TableColumn<saveBook, String> col_saveDate;

    @FXML
    private ImageView save_imageView;

    @FXML
    private Button unsaveBtn;

    @FXML
    private FontAwesomeIcon edit_icon;


    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

    public DashboardController() {
    }

    private String comboBox[] = {"Male", "Female", "Others"};

    public void gender() {

        List<String> combo = new ArrayList<>();

        for (String data : comboBox) {

            combo.add(data);
        }

        ObservableList list = FXCollections.observableList(combo);

        take_Gender.setItems(list);

    }

    public void takeBook() {

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO take VALUES (?,?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (take_FirstName.getText().isEmpty()
                    || take_LastName.getText().isEmpty()
                    || take_Gender.getSelectionModel().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please type complete Student Details");
                alert.showAndWait();
            } else if (take_titleLabel.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the book you want to take.");
                alert.showAndWait();
            } else {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, take_StudentNumber.getText());
                prepare.setString(2, take_FirstName.getText());
                prepare.setString(3, take_LastName.getText());
                prepare.setString(4, (String) take_Gender.getSelectionModel().getSelectedItem());
                prepare.setString(5, take_titleLabel.getText());
                prepare.setString(6, take_authorLabel.getText());
                prepare.setString(7, take_genreLabel.getText());
                prepare.setString(8, getData.path);
                prepare.setDate(9, sqlDate);

                String check = "Not Return";

                prepare.setString(10, check);
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successful!y take the book!");
                alert.showAndWait();

                clearTakeData();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void findBook(ActionEvent event) {

        clearFindData();


        String sql = "SELECT * FROM book WHERE bookTitle = '" + take_BookTitle.getText() + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            boolean check = false;

            Alert alert;

            if (take_BookTitle.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book.");
                alert.showAndWait();

            } else {

                while (result.next()) {

                    take_titleLabel.setText(result.getString("bookTitle"));
                    take_authorLabel.setText(result.getString("author"));
                    take_genreLabel.setText(result.getString("bookType"));
                    take_dateLabel.setText(result.getString("date"));

                    getData.path = result.getString("image");

                    String uri = "file:" + getData.path;

                    image = new Image(uri, 127, 162, false, true);
                    take_imageView.setImage(image);

                    check = true;
                }

                if (!check) {
                    take_titleLabel.setText("Book is not available!");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void studentNumberLabel() {
        take_StudentNumber.setText(getData.studentNumber);
    }
    public void clearTakeData() {

        take_BookTitle.setText("");
        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_dateLabel.setText("");
        take_imageView.setImage(null);

    }
    public void clearFindData() {

        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_dateLabel.setText("");
        take_imageView.setImage(null);

    }

    public void displayDate() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new java.util.Date());

        take_IssuedDate.setText(date);
    }
    public ObservableList<returnBook> returnBook() {

        ObservableList<returnBook> bookReturnData = FXCollections.observableArrayList();

        String check = "Not Return";

        String sql = "SELECT * FROM take WHERE checkReturn = '" + check + "' and studentNumber = '"
                + getData.studentNumber + "'";

        connect = Database.connectDB();

        try {

            returnBook rBook;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                rBook = new returnBook(result.getString("bookTitle"), result.getString("author"),
                        result.getString("bookType"), result.getString("image"),
                        result.getDate("date"));
                bookReturnData.add(rBook);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookReturnData;

    }

    public void returnBooks() {

        String sql = "UPDATE take SET checkReturn = 'Returned' WHERE bookTitle = '" + getData.takeBookTitle + "'";

        connect = Database.connectDB();

        Alert alert;

        try {

            if (return_imageView.getImage() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book you want to return");
                alert.showAndWait();

            } else {

                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully returned!");
                alert.showAndWait();

                showBookReturn();

                return_imageView.setImage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private ObservableList<returnBook> retBook;
    public void showBookReturn() {

        retBook = returnBook();

        col_return_BookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_return_Author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_return_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_return_dateIssue.setCellValueFactory(new PropertyValueFactory<>("date"));

        return_tableView.setItems(retBook);

    }
    public void selectReturnBook() {

        returnBook rBook = return_tableView.getSelectionModel().getSelectedItem();
        int num = return_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String uri = "file:" + rBook.getImage();

        image = new Image(uri, 163, 211, false, true);
        return_imageView.setImage(image);

        getData.takeBookTitle = rBook.getTitle();
    }
    public ObservableList<availableBooks> dataList() {

        ObservableList<availableBooks> listBooks = FXCollections.observableArrayList();

        String sql = "SELECT * FROM book";

        connect = Database.connectDB();

        try {

            availableBooks aBooks;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                aBooks = new availableBooks(result.getString("bookTitle"),
                        result.getString("author"), result.getString("bookType"),
                        result.getString("image"), result.getDate("date"));

                listBooks.add(aBooks);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listBooks;
    }

    public ObservableList<saveBook> savedBooksData() {

        ObservableList<saveBook> listSaveData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM save WHERE studentNumber = '"+ getData.studentNumber +"'";

        connect = Database.connectDB();

        try {

            saveBook sBook;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                sBook = new saveBook(result.getString("bookTitle"), result.getString("author"),
                        result.getString("bookType"), result.getString("image"), result.getDate("date"));

                listSaveData.add(sBook);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSaveData;
    }

    private ObservableList<saveBook> sBookList;

    public void showSavedBooks() {

        sBookList = savedBooksData();

        col_saveTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_saveAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_saveGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_saveDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        save_tableView.setItems(sBookList);

    }

    public void selectSavedBooks() {

        saveBook sBook = save_tableView.getSelectionModel().getSelectedItem();
        int num = save_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String uri = "file:" + sBook.getImage();

        image = new Image(uri, 167, 195, false, true);
        save_imageView.setImage(image);

        getData.savedImage = sBook.getImage();
        getData.savedTitle = sBook.getTitle();

    }
    public void saveBooks() {

        String sql = "INSERT INTO save VALUES (?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (availableBooks_title.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, getData.studentNumber);
                prepare.setString(2, getData.savedTitle);
                prepare.setString(3, getData.savedAuthor);
                prepare.setString(4, getData.savedGenre);
                prepare.setString(5, getData.savedImage);
                prepare.setDate(6, getData.savedDate);
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Saved.");
                alert.showAndWait();

                showSavedBooks();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void unsaveBooks() {

        String sql = "DELETE FROM save WHERE bookTitle = '" + getData.savedTitle + "'"
                + " and studentNumber = '" + getData.studentNumber + "'";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (save_imageView.getImage() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Select the book you want to unsave");
                alert.showAndWait();

            } else {

                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully unsaved.");
                alert.showAndWait();

                showSavedBooks();

                save_imageView.setImage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ObservableList<availableBooks> listBook;

    public void showAvailableBooks() {

        listBook = dataList();

        col_ab_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_ab_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_ab_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_ab_publishedDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        availableBooks_tableView.setItems(listBook);

    }

    public void selectAvailableBooks() {

        availableBooks bookData = availableBooks_tableView.getSelectionModel().getSelectedItem();

        int num = availableBooks_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1)
            return;
        availableBooks_title.setText(bookData.getTitle());

        String uri = "file:" + bookData.getImage();

        image = new Image(uri, 134, 171, false, true);

        availableBooks_imageView.setImage(image);

        getData.takeBookTitle = bookData.getTitle();
        getData.savedTitle = bookData.getTitle();
        getData.savedAuthor = bookData.getAuthor();
        getData.savedGenre = bookData.getGenre();
        getData.savedImage = bookData.getImage();
        getData.savedDate = bookData.getDate();
    }
    public void abTakeButton(ActionEvent event) {

        if (event.getSource() == take_btn) {
            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
        }
    }
    public void studentNumber() {
        studentNumber_label.setText(getData.studentNumber);
    }

    public void insertImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Image File");
        //open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image file","*png", "*jpg"));
        Stage stage = (Stage) nav_form.getScene().getWindow();

        File file = open.showOpenDialog(stage);


        if (file != null) {

            image = new Image(file.toURI().toString(), 100, 88, false, true);
            circle_image.setFill(new ImagePattern(image));

            getData.path = file.getAbsolutePath();

        }
    }
    public void navButtonDesign(ActionEvent event) {

        if (event.getSource() == availableBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(true);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            savedBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Available Books");

        } else if (event.getSource() == issueBooks_btn) {

            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);

            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            savedBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Issue Books");

        } else if (event.getSource() == returnBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(true);

            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            savedBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Return Books");

            showBookReturn();

        } else if (event.getSource() == savedBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(true);
            returnBook_form.setVisible(false);

            savedBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Saved Books");

            showSavedBooks();

        }
    }
    private double x = 0;
    private double y = 0;

    @FXML
    public void logout(ActionEvent event) {
        try {
            if (event.getSource() == logout_btn) {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent e) -> {
                    x = e.getSceneX();
                    y = e.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent e) -> {

                    stage.setX(e.getScreenX() - x);
                    stage.setY(e.getScreenY() - y);

                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

                logout_btn.getScene().getWindow().hide();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void minimize(){
        Stage stage = (Stage)minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAvailableBooks();
        studentNumber();
        studentNumberLabel();
        gender();
        displayDate();
        showBookReturn();
        showSavedBooks();


        try {
            showBookReturn();
        } catch (Exception e) {e.printStackTrace();}
    }

    private static class FontAwesomeIcon {
    }

}
