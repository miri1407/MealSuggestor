package vcmsa.ci.mealsuggester

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



        class MainActivity : AppCompatActivity() {

            // Define UI elements
            private lateinit var timeInputEditText: EditText
            private lateinit var suggestMealButton: Button
            private lateinit var resetButton: Button
            private lateinit var mealSuggestionTextView: TextView

            // Tag for logging
            private val TAG = "MealSuggestionApp"

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // Initialize UI elements
                timeInputEditText = findViewById(R.id.timeInputEditText)
                suggestMealButton = findViewById(R.id.suggestMealButton)
                resetButton = findViewById(R.id.resetButton)
                mealSuggestionTextView = findViewById(R.id.mealSuggestionTextView)

                // Set click listener for the suggest meal button
                suggestMealButton.setOnClickListener {
                    suggestMeal()
                }

                // Set click listener for the reset button
                resetButton.setOnClickListener {
                    resetApp()
                }

                Log.d(TAG, "App initialized successfully")
            }

            /**
             * Suggests a meal based on the time of day input
             */
            private fun suggestMeal() {
                val timeOfDay = timeInputEditText.text.toString().trim().lowercase()

                // Log the input time for debugging
                Log.d(TAG, "User entered time: $timeOfDay")

                if (timeOfDay.isEmpty()) {
                    // Handle empty input
                    Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "Empty input received")
                    return
                }

                // Determine the meal suggestion based on time of day using if-else statements
                val mealSuggestion = when {
                    timeOfDay.contains("morning") && !timeOfDay.contains("mid") -> {
                        "How about some delicious Eggs Benedict for breakfast? Perfect way to start your day!"
                    }
                    timeOfDay.contains("mid-morning") || timeOfDay == "mid morning" -> {
                        "It's mid-morning snack time! Try a banana or an apple with some almond butter."
                    }
                    timeOfDay.contains("afternoon") && !timeOfDay.contains("mid") -> {
                        "Lunchtime! A fresh turkey avocado sandwich with a side salad would be perfect right now."
                    }
                    timeOfDay.contains("mid-afternoon") || timeOfDay == "mid afternoon" -> {
                        "Need an afternoon pick-me-up? How about some Greek yogurt with honey and granola?"
                    }
                    timeOfDay.contains("dinner") -> {
                        "Dinner time! A comforting bowl of pasta primavera with grilled chicken would hit the spot."
                    }
                    timeOfDay.contains("after dinner") -> {
                        "Craving something sweet? A small bowl of vanilla ice cream with fresh berries would be delightful."
                    }
                    else -> {
                        // Handle invalid input
                        Toast.makeText(this, "Please enter a valid time (Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, or After dinner)", Toast.LENGTH_LONG).show()
                        Log.w(TAG, "Invalid input: $timeOfDay")
                        return
                    }
                }

                // Display the meal suggestion
                mealSuggestionTextView.text = mealSuggestion
                Log.d(TAG, "Suggested meal: $mealSuggestion")
            }

            /**
             * Resets the app by clearing the input field and the meal suggestion
             */
            private fun resetApp() {
                timeInputEditText.text.clear()
                mealSuggestionTextView.text = ""
                Log.d(TAG, "App reset")
            }
        }






