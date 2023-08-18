package com.example.witchercharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.witchercharacters.model.Character
import com.example.witchercharacters.model.CharactersRepositories
import com.example.witchercharacters.ui.theme.WitcherCharactersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WitcherCharactersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CharactersApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersApp() {
    Scaffold(
        topBar = { WitcherTopBar() }
    ) {
        LazyColumn(contentPadding = it) {
            items(CharactersRepositories.characters) {
                CharacterCard(
                    character = it,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = character.nameRes),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Box(
                Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.onPrimary),

            ) {
                Image(
                    painter = painterResource(id = character.imagerRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Text(
                text = stringResource(id = character.descriptionRes),
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(8.dp)
)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WitcherTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "The Witcher",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    WitcherCharactersTheme {
        CharactersApp()
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterCardDarkPreview() {
    WitcherCharactersTheme(darkTheme = true) {
        CharactersApp()
    }
}
