package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    // Import and declare Repository interfaces used
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;


    // Constructor to inject customer, cart, and item Repos
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Receive cart info from dto
        Cart cart = purchase.getCart();
        // Populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        // Populate customer with cart
        Customer customer = purchase.getCustomer();

        // Generate tracking number
        // Generate random UUID number (UUID version-4)
        // UUID = Universally Unique IDentifier
        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // ForEach loop to add items to cart
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });

        // Set status of order
        cart.setStatus(StatusType.ORDERED);

        // Save customer and cart to database
        customerRepository.save(customer);
        cartRepository.save(cart);

        // Return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
}
