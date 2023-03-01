package com.example.dontgetbored.util

import kotlin.math.roundToInt

class Util {
    companion object {
        fun boredPriceToString(price: Double): String {
            if (price in 0.1..0.3) return "Low"
            if (price in 0.4..0.6) return "Normal"
            if (price in 0.7..1.0) return "High"
            return "Free"
        }

        fun boredAccessibilityFormatter(accessibility: Double): String {
            return "${(100 - (accessibility * 100)).roundToInt()}%"
        }
    }
}