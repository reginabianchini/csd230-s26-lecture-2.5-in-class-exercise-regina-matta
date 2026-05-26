package csd230.s26.lab1.controllers;

import csd230.s26.lab1.entities.BookEntity;
import csd230.s26.lab1.entities.CartEntity;
import csd230.s26.lab1.repositories.BookRepository;
import csd230.s26.lab1.repositories.CartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final CartRepository cartRepository;

    // Standard Constructor Injection
    public BookController(BookRepository bookRepository, CartRepository cartRepository) {
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList"; // Refers to bookList.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute BookEntity book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            // STEP 1: Remove book from all Many-to-Many Cart relationships
            for (CartEntity cart : book.getCarts()) {
                cart.getProducts().remove(book);
                cartRepository.save(cart);
            }
            // STEP 2: Now it is safe to delete
            bookRepository.deleteById(id);
        }
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book); // This object NOW HAS AN ID (e.g., 5)
        return "addBook";
    }


//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        // Look for the book by ID
//        BookEntity book = bookRepository.findById(id).orElse(null);
//
//        if (book != null) {
//            model.addAttribute("book", book); // Pack the existing book into the suitcase
//            return "book-form"; // Send them to the exact same form used for adding
//        }
//
//        return "redirect:/books"; // If book not found, go back to list
//    }
}
