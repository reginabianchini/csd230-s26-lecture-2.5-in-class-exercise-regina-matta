package csd230.s26.lab1.repositories;

import com.github.javafaker.Faker;
import csd230.s26.lab1.entities.BookEntity;
import csd230.s26.lab1.entities.SmartphoneEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Use real MySQL, not H2
@Transactional(propagation = Propagation.NOT_SUPPORTED) // Don't rollback so data persists for inspection
class ProductRepositoryTest {


    @Autowired
    private BookRepository BookRepository;

    @Test
    void testSaveAndRetrieveBook() {
        Faker faker = new Faker();

        // 1. Create a fake book
        BookEntity book = new BookEntity(
                faker.book().author(),
                faker.book().title(),
                29.99,
                10
        );

        // 2. Save to database
        BookRepository.save(book);
        Long savedId = book.getId();
        assertNotNull(savedId, "ID should be generated upon saving");

        // 3. Retrieve and Verify
        BookEntity foundBook = (BookEntity) BookRepository.findById(savedId).orElseThrow();
        assertEquals(book.getTitle(), foundBook.getTitle());
        assertEquals(book.getAuthor(), foundBook.getAuthor());

        System.out.println("Successfully verified book: " + foundBook.getTitle());
    }
    @Test
    void testSaveAndDeleteBook(){
        BookEntity book = new BookEntity(
                "Test Author",
                "Test Title",
                19.99,
                5
        );
        BookEntity saved = BookRepository.save(book);
        Long id = saved.getId();
        assertNotNull(id);

        assertTrue(BookRepository.findById(id).isPresent());

        BookRepository.deleteById(id);

        assertFalse(BookRepository.findById(id).isPresent());
    }

    @Test
    void testFindByAuthor(){
        BookEntity book1 = new BookEntity("Paul Bailey", "Book 1", 15.0, 1);
        BookEntity book2 = new BookEntity("Paul Bailey", "Book 2", 18.0, 1);
        BookEntity book3 = new BookEntity("Beatrix Potter","Book 3", 14.0, 1);

        BookRepository.save(book1);
        BookRepository.save(book2);
        BookRepository.save(book3);

        List<BookEntity> results = BookRepository.findByAuthor("Paul Bailey");

        assertEquals(2, results.size());
        results.forEach(b ->
                assertEquals("Paul Bailey", b.getAuthor())
        );
    }
    @Test
    void testFindByTitleContaining(){
        BookEntity book1 = new BookEntity("A", "Java Basics", 15.0,1);
        BookEntity book2 = new BookEntity("B", "Advanced Java", 18.0,1);
        BookEntity book3 = new BookEntity("C", "Python Guide", 14.0,1);

        BookRepository.save(book1);
        BookRepository.save(book2);
        BookRepository.save(book3);

        List<BookEntity> results = BookRepository.findByTitleContaining("Java");

        assertEquals(2, results.size());
    }
    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Test
    void testSmartphoneSaveAndRetrieve() {
        SmartphoneEntity phone = new SmartphoneEntity(
                6.5,
                48
        );

        SmartphoneEntity saved = smartphoneRepository.save(phone);
        Long id = saved.getId();

        assertNotNull(id);

        SmartphoneEntity found = (SmartphoneEntity) smartphoneRepository.findById(id).orElseThrow();

        assertEquals(6.5, found.getScreenSize());
        assertEquals (48, found.getCameraMegapixels());
    }


}
