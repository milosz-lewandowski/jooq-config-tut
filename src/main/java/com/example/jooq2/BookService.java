package com.example.jooq2;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Author;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  public DSLContext dslContext;

  public void insertAuthor(Author author) {
    dslContext.insertInto(Tables.AUTHOR,
            Tables.AUTHOR.ID,
            Tables.AUTHOR.FIRST_NAME,
            Tables.AUTHOR.LAST_NAME)
        .values(author.getId(), author.getFirstName(), author.getLastName())
        .execute();
  }

  public List<Author> getAuthors() {
    return dslContext.selectFrom(Tables.AUTHOR).fetchInto(Author.class);
  }
}
