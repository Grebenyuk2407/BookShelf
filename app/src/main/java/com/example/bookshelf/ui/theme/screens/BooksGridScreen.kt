package com.example.bookshelf.ui.theme.screens


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookshelf.data.Book


@Composable
fun BooksGridScreen(
    books:List<Book>,
    modifier: Modifier,
    onBookClicked :(Book) -> Unit
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp)
        ){
        itemsIndexed(books){_, book ->
            BookCard(book = book, modifier, onBookClicked)
        }
    }
}

