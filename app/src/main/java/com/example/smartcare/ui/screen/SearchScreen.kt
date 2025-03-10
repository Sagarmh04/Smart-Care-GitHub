package com.example.smartcare.ui.screen

import AppTheme
import android.content.Context
import android.os.Build
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.smartcare.City.City
import com.example.smartcare.City.parsedCities
import com.example.smartcare.Hospitals.Hospital
import com.example.smartcare.Hospitals.allHospitalData
import com.example.smartcare.ui.theme.white
import com.example.smartcare.viewModel.SearchViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    hideBottomScreen: () -> Unit
) {
    LaunchedEffect(hideBottomScreen) {
        hideBottomScreen()
    }
    val viewModel = viewModel<SearchViewModel>()
    // State management
    var isSearchingLocation by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    val selectedCity by viewModel.selectedCity.observeAsState()
    var hospitalQuery by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    var onShow by remember { mutableStateOf(false) }
    var filteredHospitals : List<Hospital> = allHospitalData.find { it.cityName.equals(selectedCity?.name) }?.hospitals?: emptyList()
    fun hideKeyboard(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
    }
    LaunchedEffect(Unit) {
        viewModel.allCities.value?.let { viewModel.selectCity(it.get(0)) }
    }
    // Wrap entire screen in Box for bottom sheet placement
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            // 1. City Selector Header - ONLY CHANGE: Added click handler
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                    .clickable(onClick = { isSearchingLocation = true }), // Changed here
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.background(white)) {
                    Row() {
                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 6.dp, bottom = 6.dp),
                            text = selectedCity?.name ?: "Select City",
                            style = AppTheme.typography.heading.copy(
                                fontSize = 32.sp,
                                letterSpacing = 2.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                        Spacer(Modifier.width(5.dp))
                        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Change city",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        Spacer(Modifier.width(6.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            //activate after the click on location search
            if (isSearchingLocation) {
                LocationSearchSection(
                    searchQuery = searchQuery,
                    onQueryChange = { searchQuery = it },
                    focusRequester = focusRequester,
                    onBack = {
                        isSearchingLocation = false
                        searchQuery = ""
                    },
                    allCities = parsedCities,
                    onCitySelected = { city: City ->
                        viewModel.selectCity(city)
                        isSearchingLocation = false
                        searchQuery = ""
                    }
                )
            } else {
                Column {
                        HospitalSearchField(
                            query = hospitalQuery,
                            onQueryChange = {
                                viewModel.updateHospitalSearchQuery(it)
                                hospitalQuery=it
                                isSearchActive=true
                                            },
                            onFocusChange = { isSearchActive = it },
                            focusRequester = focusRequester,
                            modifier = Modifier.padding(16.dp),
                            onBack = {
                                onShow=false
                                isSearchActive = false
                                searchQuery = ""
                            }
                        )
                    // Dropdown List
                    if (isSearchActive) {
                        HospitalDropdown(
                            filteredHospitals,
                            hospitalQuery,
                            onHospitalSelect = { hospital ->
                                val name = selectedCity?.name
                                navController.currentBackStackEntry?.savedStateHandle?.set("city",
                                    name
                                )
                                navController.currentBackStackEntry?.savedStateHandle?.set(key = "hospital",hospital)
                                navController.navigate("hospitalDetails")
                                isSearchActive = false
                                hideKeyboard(context)
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),

                        )
                    } else {
                        // Original content wrapped in scroll
                        MainContentSection(
                            filteredHospitals,
                            navController,
                            viewModel,
                            selectedCity)
                    }
                }

            }
        }
    }
}

@Composable
private fun HospitalItem(
    hospital: Hospital,
    onClick: (Hospital) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(hospital) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        // Your existing HospitalPreviewItem content
        HospitalPreviewItem(hospital)
    }
}

@Composable
private fun EmptyState(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Composable
fun MainContentSection(
    filteredHospitals: List<Hospital>,
    navController: NavController,
    viewModel: SearchViewModel,
    selectedCity: City?
) {
    val selectedCity by viewModel.selectedCity.observeAsState()
    val hospitalQuery by viewModel.hospitalSearchQuery.observeAsState("")
    var showFilters by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {

        Spacer(modifier = Modifier.height(24.dp))

        // 3. Categories Header
        Text(
            text = "Medical Specialties",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 4. Categories Row (Will enhance in next steps)

        Spacer(modifier = Modifier.height(24.dp))

        // 5. Hospitals Header
        Text(
            text = "Top Rated Hospitals",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        HospitalList(
            hospitals = filteredHospitals,
            onHospitalClick = { hospital ->
                val name = selectedCity?.name
                navController.currentBackStackEntry?.savedStateHandle?.set("city",
                    name
                )
                navController.currentBackStackEntry?.savedStateHandle?.set("hospital",hospital)
                navController.navigate("hospitalDetails")
            }
        )
    }
}

@Composable
private fun HospitalList(
    hospitals: List<Hospital>,
    onHospitalClick: (Hospital) -> Unit
) {
    if (hospitals.isEmpty()) {
        EmptyState(message = "No hospitals found matching your criteria")
    } else {
        LazyColumn(modifier = Modifier.fillMaxWidth()
            .heightIn(max = 400.dp)) {
            items(hospitals) { hospital ->
                HospitalItem(hospital, onHospitalClick)
            }
        }
    }
}

@Composable
private fun HospitalSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    var debouncedQuery by remember { mutableStateOf(query) }
    val keyboardController = LocalSoftwareKeyboardController.current // Add this

    // Debounce implementation
    LaunchedEffect(query) {
        delay(300)
        debouncedQuery = query
    }
    Column {
        // Search Bar
        Box(modifier = Modifier.padding(bottom =  16.dp, start = 16.dp, end = 16.dp)) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                    .focusRequester(focusRequester)
                    .onFocusChanged { state ->  //observe TODO oooooooooooooooo
                        onFocusChange(state.isFocused)
                    },
                placeholder = {
                    Text("Search hospitals...",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                              },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary)
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = {
                            onQueryChange("")
                            focusRequester.requestFocus()
                        }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }else{
                        IconButton(onClick = {
                            onBack()
                            keyboardController?.hide() // Hide keyboard when exiting
                        }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                singleLine = true
            )
        }
    }
}

@Composable
private fun HospitalPreviewItem(hospital: Hospital) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Default.LocalHospital,
                contentDescription = "Hospital",
                modifier = Modifier.align(Alignment.Center))
        }

        Spacer(Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = hospital.name,
                style = MaterialTheme.typography.titleMedium)
            Text(
                text = "${hospital.rating} ★ (${hospital.reviewCount} reviews)",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary)
            Text(
                text = "${hospital.distance} km away · ${hospital.openingHours}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        }

        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "View details")
    }
}

@Composable
private fun HospitalDropdown(
    filteredHospitals: List<Hospital>,
    searchQuery: String,
    onHospitalSelect: (Hospital) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .shadow(elevation = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 400.dp)
        ) {
            items(items =  filteredHospitals.filter { it.name.contains(searchQuery, ignoreCase = true) }) { hospital ->
                HospitalDropdownItem(hospital, onHospitalSelect)
            }


        if (filteredHospitals.isEmpty()) {
                item {
                    Text(
                        text = "No matching hospitals found",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

@Composable
private fun HospitalDropdownItem(
    hospital: Hospital,
    onSelect: (Hospital) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(hospital) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.LocalHospital,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = hospital.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${hospital.distance} km • ${hospital.rating} ★",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }
        Spacer(Modifier.width(8.dp))
        Text(
            text = hospital.district,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun LocationSearchSection(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    focusRequester: FocusRequester,
    onBack: () -> Unit,
    allCities: List<City>,
    onCitySelected: (City) -> Unit
) {
    var debouncedQuery by remember { mutableStateOf(searchQuery) }
    val keyboardController = LocalSoftwareKeyboardController.current // Add this

    // Request focus and show keyboard when this composable appears
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show() // Explicitly show keyboard
    }

    // Debounce implementation
    LaunchedEffect(searchQuery) {
        delay(300)
        debouncedQuery = searchQuery
    }

    Column {
        // Search Bar
        Box(modifier = Modifier.padding(bottom =  16.dp, start = 16.dp, end = 16.dp)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                    .focusRequester(focusRequester),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text("Search locations...",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary)
                },
                trailingIcon = {
                    IconButton(onClick = {
                        onBack()
                        keyboardController?.hide() // Hide keyboard when exiting
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        }

        // Filtered Cities List
        LazyColumn(modifier = Modifier.fillMaxWidth()
            .heightIn(max = 400.dp)) {
            items(
                items = allCities.filter {
                    it.name.contains(debouncedQuery, ignoreCase = true) ||
                            it.district.contains(debouncedQuery, ignoreCase = true)
                },
                key = { it.id }
            ) { city ->
                CityListItem(
                    city = city,
                    onSelect = { onCitySelected(city) }
                )
            }
        }
    }
}
@Composable
private fun CityListItem(city: City, onSelect: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onSelect),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = city.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "${city.district}, Karnataka",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}


