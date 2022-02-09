import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;

    private Restaurant createRestaurant(){
        return new Restaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
    }

    private void addItemsToRestaurantMenu() {
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        restaurant = createRestaurant();
        boolean b = restaurant.isRestaurantOpen();
        assertTrue(b);
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        LocalTime openingTime = LocalTime.parse("01:30:00");
        LocalTime closingTime = LocalTime.parse("05:00:00");
        restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        boolean b = restaurant.isRestaurantOpen();
        assertFalse(b);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        restaurant = createRestaurant();
        addItemsToRestaurantMenu();
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }

    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        restaurant = createRestaurant();
        addItemsToRestaurantMenu();
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        restaurant = createRestaurant();
        addItemsToRestaurantMenu();
        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }

    @Test
    public void display_zero_if_no_item_is_selected(){
        restaurant = createRestaurant();
        addItemsToRestaurantMenu();
        int sum = 0;
        assertEquals(0,sum);

    }
    @Test
    public void display_total_order_cost_of_selected_items(){
        restaurant = createRestaurant();
        addItemsToRestaurantMenu();
        int costItem1 = restaurant.orderCost(restaurant.getMenu().get(0));
        int costItem2 = restaurant.orderCost(restaurant.getMenu().get(1));
        int sum = costItem1+costItem2;
        assertEquals(388,sum);
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}

//    private void addItemsToRestaurantMenu() {
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);