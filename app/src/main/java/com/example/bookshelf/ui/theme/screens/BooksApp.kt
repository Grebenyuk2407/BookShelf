package com.example.bookshelf.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.BooksViewModel
import com.example.bookshelf.data.Book
import com.example.bookshelf.ui.theme.MainAppBar

@Composable
fun BooksApp(
    modifier: Modifier = Modifier,
    onBookClicked :(Book) -> Unit
) {
    val booksViewModel: BooksViewModel =
        viewModel(factory = BooksViewModel.Factory)
    val searchWidgetState = booksViewModel.searchWidgetState
    val searchTextState = booksViewModel.searchTextState

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState.value,
                searchTextState = searchTextState.value,
                onTextChange = {
                               booksViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                                 booksViewModel.updateSearchWidgetState(newValue = BooksViewModel.SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    booksViewModel.getBooks(it)
                },
                onSearchTriggered = {
                    booksViewModel.updateSearchWidgetState(BooksViewModel.SearchWidgetState.OPENED)
                }
            )
        }

    ) {
        Surface(modifier = modifier
            .fillMaxSize()
            .padding(it),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                booksUiState = booksViewModel.booksUiState,
                retryAction = { booksViewModel.getBooks() },
                modifier = modifier,
                onBookClicked
            )
        }
    }
}