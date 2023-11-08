package se.lu.ics.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import se.lu.ics.models.CreditCard;
import se.lu.ics.models.Customer;
import se.lu.ics.models.CustomerRegister;

public class MainViewController {

    private CustomerRegister customerRegister;

    @FXML
    private TextField textFieldCustomerId;

    @FXML
    private TextField textFieldCustomerName;

    @FXML
    private TextField textFieldCardNumber;

    @FXML
    private TextField textFieldCardType;

    @FXML
    private RadioButton radioButtonHasCard;

    @FXML
    private RadioButton radioButtonNoCard;

    @FXML
    private Label labelResponse;

    @FXML
    public void handleButtonCustomerAddAction(ActionEvent event) {
        String customerId = textFieldCustomerId.getText();
        String name = textFieldCustomerName.getText();

        Customer customer = new Customer(customerId, name);

        customerRegister.addCustomer(customer);

        if(radioButtonHasCard.isSelected()) {
            String cardNumber = textFieldCardNumber.getText();
            String cardType = textFieldCardType.getText();

            CreditCard creditCard = new CreditCard(cardNumber, cardType);

            customer.setCreditCard(creditCard);
            creditCard.setHolder(customer);

            String response = "Customer added: " + customer.getName() + " with credit card: " + creditCard.getNumber();

            labelResponse.setText(response);
        }

        String response = "Customer added: " + customer.getName();

        labelResponse.setText(response);
    }


    @FXML
    public void handleButtonCustomerFindAction(ActionEvent event) {
        String customerId = textFieldCustomerId.getText();

        Customer foundCustomer = customerRegister.findCustomer(customerId);

        if(foundCustomer != null) {
            String response = "Customer found: " + foundCustomer.getName();
            textFieldCustomerId.setText(foundCustomer.getCustomerId());
            textFieldCustomerName.setText(foundCustomer.getName());

            if(foundCustomer.getCreditCard() != null) {
                textFieldCardNumber.setText(foundCustomer.getCreditCard().getNumber());
                textFieldCardType.setText(foundCustomer.getCreditCard().getType());
                radioButtonHasCard.setSelected(true);
            } else {
                textFieldCardNumber.setText("");
                textFieldCardType.setText("");
                radioButtonNoCard.setSelected(true);
            }

            labelResponse.setText(response);
        } else {
            String response = "Customer not found";

            labelResponse.setText(response);
        }
    }

    @FXML
    public void handleButtonCustomerDeleteAction(ActionEvent event) {
        String customerId = textFieldCustomerId.getText();

        customerRegister.removeCustomer(customerId);

        String response = "Customer deleted";

        labelResponse.setText(response);
    }

    @FXML
    public void handleButtonCustomerSetNameAction(ActionEvent event) {
        String customerId = textFieldCustomerId.getText();
        String name = textFieldCustomerName.getText();

        customerRegister.setCustomerName(customerId, name);

        String response = "Customer name changed";

        labelResponse.setText(response);
    }

    public void setCustomerRegister(CustomerRegister customerRegister) {
        this.customerRegister = customerRegister;
    }
}
