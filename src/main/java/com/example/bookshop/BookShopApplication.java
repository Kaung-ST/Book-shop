package com.example.bookshop;

import com.example.bookshop.dao.AuthorDao;
import com.example.bookshop.dao.BookDao;
import com.example.bookshop.dao.GenreDao;
import com.example.bookshop.dao.PublisherDao;
import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.entity.Publisher;
import com.example.bookshop.util.IsbnGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookShopApplication {
    private final AuthorDao authorDao;
    private final BookDao bookdao;
    private final GenreDao genreDao;
    private final PublisherDao publisherDao;

    @Bean
    @Transactional
    public ApplicationRunner runner(){
        return  r->{
            Author author1=new Author("Charles Dickens","charles@gmail.com");
            Author author2=new Author("Thomas Hardly","thomas@gmail.com");

            Publisher publisher1=new Publisher("A Lin Yaung","alinyaung@gmail.com");
            Publisher publisher2=new Publisher("New Era","newEra@gmail.com");

            Genre genre1=new Genre();
            genre1.setGenreName("Tragedy");
            Genre genre2=new Genre();
            genre2.setGenreName("Adventure");

            Book book1 =new Book(
                    1,
                    IsbnGenerator.generate(),
                    "A Tale of two Cities",
                        "a short description",
                    50.3,
                    20,
                        "https://source.unsplash.com/400x300/?cities"
                    );
            Book book2 =new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Great Expectations",
                    "a Description",
                    22.3,
                    20,
                    "https://source.unsplash.com/400x300/?flower"
            );
            Book book3 =new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Return of the Native",
                    "Excellent",
                    40.3,
                    20,
                    "https://source.unsplash.com/400x300/?ocean"
            );
            Book book4 =new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Far From the Maddening Crowd",
                    "Excellent",
                    50.5,
                    20,
                    "https://source.unsplash.com/400x300/?nature"
            );
            Book book5 =new Book(
                    5,
                    IsbnGenerator.generate(),
                    "Into the Forest",
                    "Excellent forest",
                    50.5,
                    20,
                    "https://source.unsplash.com/400x300/?forest"
            );
            Book book6 =new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Into the Wild",
                    "Wild forest",
                    40.5,
                    20,
                    "https://source.unsplash.com/400x300/?darkforest"
            );


            //mapping
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);
            author2.addBook(book4);
            author2.addBook(book5);
            author2.addBook(book6);

            Publisher pub1=publisherDao.save(publisher1);
            pub1.addBook(book1);
            pub1.addBook(book2);
            pub1.addBook(book3);
            Publisher pub2=publisherDao.save(publisher2);
            pub2.addBook(book4);
            pub2.addBook(book5);
            pub2.addBook(book6);

//            publisher1.addBook(book1);
//            publisher1.addBook(book2);
//            publisher1.addBook(book3);
//
//            publisher2.addBook(book4);
//            publisher2.addBook(book5);
//            publisher2.addBook(book6);
        Genre gen1=genreDao.save(genre1);

        Genre gen2=genreDao.save(genre2);

            book1.addGenres(gen1);
            book2.addGenres(gen1);
            book3.addGenres(gen1);
            book4.addGenres(gen2);
            book5.addGenres(gen2);
            book6.addGenres(gen2);

        authorDao.save(author1);
        authorDao.save(author2);


        };
    }
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);

    }
}