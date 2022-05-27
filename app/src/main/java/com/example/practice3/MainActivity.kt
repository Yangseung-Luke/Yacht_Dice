package com.example.practice3

import android.content.DialogInterface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.practice3.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: com.example.practice3.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Round_Text: TextView = findViewById(R.id.round)

        var round_number: Int = 0

        val Aces_Text: TextView = findViewById(R.id.aces_text)
        val Dueces_Text: TextView = findViewById(R.id.dueces_text)
        val Triple_Text: TextView = findViewById(R.id.threes_text)
        val Quad_Text: TextView = findViewById(R.id.fours_text)
        val Penta_Text: TextView = findViewById(R.id.fives_text)
        val Hexa_Text: TextView = findViewById(R.id.sixes_text)

        val TotalUp_Text: TextView = findViewById(R.id.totalup)
        val Bonus_Text: TextView = findViewById(R.id.bonus)

        val check = BooleanArray(6) { false }
        var check1: Boolean = false
        val num = IntArray(6) { 0 }
        var sum_up: Int = 0
        var bonus_point: Int = 0

        val Choice_Text: TextView = findViewById(R.id.choice_text)
        val Fourcard_Text: TextView = findViewById(R.id.four_card_text)
        val Fullhouse_Text: TextView = findViewById(R.id.full_house_text)
        val S_straight_Text: TextView = findViewById(R.id.small_straight_text)
        val L_straight_Text: TextView = findViewById(R.id.large_straight_text)
        val Yacht_Text: TextView = findViewById(R.id.yacht_text)

        val TotalDown_Text: TextView = findViewById(R.id.totaldown)

        val check_down = BooleanArray(6) { false }
        var check2: Boolean = false
        val num_down = IntArray(6) { 0 }
        var sum_down: Int = 0

        val Dice = arrayOfNulls<ImageView>(5)

        binding.aces.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.ace_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Aces_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[0]
                    sum_up += plus_Int
                    Aces_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[0] = true
                    num[0] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Aces_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[0]
                num[0] = 0
                Aces_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[0] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[에이스] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.deuces.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.duece_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Dueces_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[1]
                    sum_up += plus_Int
                    Dueces_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[1] = true
                    num[1] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Dueces_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[1]
                num[1] = 0
                Dueces_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[1] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[듀스] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.threes.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.triple_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Triple_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[2]
                    sum_up += plus_Int
                    Triple_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[2] = true
                    num[2] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()

                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Triple_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[2]
                num[2] = 0
                Triple_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[2] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[트리플] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.fours.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.quad_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Quad_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[3]
                    sum_up += plus_Int
                    Quad_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[3] = true
                    num[3] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Quad_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[3]
                num[3] = 0
                Quad_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[3] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[쿼드] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.fives.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.penta_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Penta_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[4]
                    sum_up += plus_Int
                    Penta_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[4] = true
                    num[4] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Penta_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[4]
                num[4] = 0
                Penta_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[4] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[펜타] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.sixes.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.hexa_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Hexa_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_up -= num[5]
                    sum_up += plus_Int
                    Hexa_Text.text = ET.text
                    TotalUp_Text.text = ("" + sum_up)
                    val bonus_Int = TotalUp_Text.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        Bonus_Text.text = "35"
                        bonus_point = 35
                    }
                    check[5] = true
                    num[5] = plus_Int
                    for (i in 0..5) {
                        if (check[i] == false) break
                        if (i == 5) {
                            if (TotalUp_Text.getText().toString().toInt() < 63) {
                                Bonus_Text.text = "0"
                                bonus_point = 0
                            }
                            check1 = true
                        }
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Hexa_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_up -= num[5]
                num[5] = 0
                Hexa_Text.text = "-"
                Bonus_Text.text = "-"
                TotalUp_Text.text = ("" + sum_up)
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check[5] = false
                check1 = false
                if (round_number == 0) TotalUp_Text.text = "-"
                Toast.makeText(this, "[헥사] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        binding.choice.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.choice_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Choice_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[0]
                    sum_down += plus_Int
                    Choice_Text.text = ET.text
                    check_down[0] = true
                    num_down[0] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Choice_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[0]
                num_down[0] = 0
                Choice_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[0] = false
                check2 = false
                Toast.makeText(this, "[초이스] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.fourCard.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.fourcard_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Fourcard_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[1]
                    sum_down += plus_Int
                    Fourcard_Text.text = ET.text
                    check_down[1] = true
                    num_down[1] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Fourcard_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[1]
                num_down[1] = 0
                Fourcard_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[1] = false
                check2 = false
                Toast.makeText(this, "[포카드] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.fullHouse.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.fullhouse_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Fullhouse_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[2]
                    sum_down += plus_Int
                    Fullhouse_Text.text = ET.text
                    check_down[2] = true
                    num_down[2] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Fullhouse_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[2]
                num_down[2] = 0
                Fullhouse_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[2] = false
                check2 = false
                Toast.makeText(this, "[풀하우스] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.smallStraight.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.small_straight_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (S_straight_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[3]
                    sum_down += plus_Int
                    S_straight_Text.text = ET.text
                    check_down[3] = true
                    num_down[3] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (S_straight_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[3]
                num_down[3] = 0
                S_straight_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[3] = false
                check2 = false
                Toast.makeText(this, "[S 스트레이트] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.largeStraight.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.large_straight_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (L_straight_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[4]
                    sum_down += plus_Int
                    L_straight_Text.text = ET.text
                    check_down[4] = true
                    num_down[4] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (L_straight_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[4]
                num_down[4] = 0
                L_straight_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[4] = false
                check2 = false
                Toast.makeText(this, "[L 스트레이트] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        binding.yacht.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.yacht_dialog, null)
            val Ok: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val ET: EditText = myLayout.findViewById(R.id.input)
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Ok.setOnClickListener {
                if (ET.text.toString().toIntOrNull() != null) {
                    if (Yacht_Text.getText().toString() == "-")
                        Round_Text.text = ("Round " + (++round_number) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sum_down -= num_down[5]
                    sum_down += plus_Int
                    Yacht_Text.text = ET.text
                    check_down[5] = true
                    num_down[5] = plus_Int
                    for (i in 0..5) {
                        if (check_down[i] == false) break
                        if (i == 5)
                            check2 = true
                    }
                    TotalDown_Text.text = ("" + (sum_up + sum_down + bonus_point))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (Yacht_Text.getText().toString() != "-")
                    Round_Text.text = ("Round " + (--round_number) + "/12")
                sum_down -= num_down[5]
                num_down[5] = 0
                Yacht_Text.text = "-"
                TotalDown_Text.text =
                    if (round_number == 0) "-" else ("" + (sum_up + sum_down + bonus_point))
                check_down[5] = false
                check2 = false
                Toast.makeText(this, "[야추] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        binding.dice.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.dice_dialog, null)
            val Dice_value = arrayOf<Int>(1, 1, 1, 1, 1)
            val Throw_Dice: Button = myLayout.findViewById(R.id.okBtn)

            val Dice_text = arrayOf<TextView>(myLayout.findViewById(R.id.text_1),
                myLayout.findViewById(R.id.text_2),
                myLayout.findViewById(R.id.text_3),
                myLayout.findViewById(R.id.text_4),
                myLayout.findViewById(R.id.text_5))

            val Dice_button_Up = arrayOf<Button>(myLayout.findViewById(R.id.dice_ace),
                myLayout.findViewById(R.id.dice_duece),
                myLayout.findViewById(R.id.dice_triple),
                myLayout.findViewById(R.id.dice_quad),
                myLayout.findViewById(R.id.dice_penta),
                myLayout.findViewById(R.id.dice_hexa))
            val Dice_button_Down = arrayOf<Button>(myLayout.findViewById(R.id.dice_choice),
                myLayout.findViewById(R.id.dice_fourcard),
                myLayout.findViewById(R.id.dice_fullhouse),
                myLayout.findViewById(R.id.dice_s_straight),
                myLayout.findViewById(R.id.dice_l_straight),
                myLayout.findViewById(R.id.dice_yacht))

            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()

            Dice[0] = myLayout.findViewById(R.id.dice1)
            Dice[1] = myLayout.findViewById(R.id.dice2)
            Dice[2] = myLayout.findViewById(R.id.dice3)
            Dice[3] = myLayout.findViewById(R.id.dice4)
            Dice[4] = myLayout.findViewById(R.id.dice5)
            val Chance: TextView = myLayout.findViewById(R.id.chance)
            for (i in 0..4) Dice[i]?.setBackgroundResource(R.drawable.false_bg)
            val stat = Array<Boolean>(5) { false }
            var chance_Int = 0

            for (i in 0..4) {
                Dice[i]?.setOnClickListener {
                    if(chance_Int==0)
                        Toast.makeText(this, "고정시킬 수 없습니다", Toast.LENGTH_SHORT).show()
                    else{
                        stat[i] = !stat[i]
                        if (stat[i]) Dice[i]?.setBackgroundResource(R.drawable.true_bg)
                        else Dice[i]?.setBackgroundResource(R.drawable.false_bg)
                    }
                }
            }

            Throw_Dice.setOnClickListener {
                val random = Random()
                val diceID = arrayOf<Int>(R.drawable.dice_one,
                    R.drawable.dice_two,
                    R.drawable.dice_three,
                    R.drawable.dice_four,
                    R.drawable.dice_five,
                    R.drawable.dice_six)
                val rand = arrayOf<Int>(random.nextInt(6),
                    random.nextInt(6),
                    random.nextInt(6),
                    random.nextInt(6),
                    random.nextInt(6))
                if (chance_Int < 3) {
                    for (i in 0..4) if (!stat[i]) {
                        Dice[i]?.setImageResource(diceID[rand[i]])
                        Dice_value[i] = rand[i] + 1
                        Dice_text[i].text = ("" + (rand[i] + 1))
                    }
                    Chance.text = ("Chance " + ++chance_Int + "/3")
                } else {
                    Toast.makeText(this, "더 이상 던질 수 없습니다", Toast.LENGTH_SHORT).show()
                }
            }
            Dice_button_Up[0].setOnClickListener {

            }
        }
        binding.reset.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.reset_dialog, null)
            val Reset: Button = myLayout.findViewById(R.id.okBtn)
            val Cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            Reset.setOnClickListener {
                round_number = 0
                check1 = false
                check2 = false
                sum_up = 0
                sum_down = 0
                bonus_point = 0
                for (i in 0..5) {
                    num[i] = 0
                    num_down[i] = 0
                    check[i] = false
                    check_down[i] = false
                }
                Round_Text.text = "Round 0/12"

                Aces_Text.text = "-"
                Dueces_Text.text = "-"
                Triple_Text.text = "-"
                Quad_Text.text = "-"
                Penta_Text.text = "-"
                Hexa_Text.text = "-"

                TotalUp_Text.text = "-"
                Bonus_Text.text = "-"

                Choice_Text.text = "-"
                Fourcard_Text.text = "-"
                Fullhouse_Text.text = "-"
                S_straight_Text.text = "-"
                L_straight_Text.text = "-"
                Yacht_Text.text = "-"

                TotalDown_Text.text = "-"

                Toast.makeText(this, "초기화 되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}