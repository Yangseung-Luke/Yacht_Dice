package com.example.practice3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.practice3.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("CutPasteId", "InflateParams", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val roundText: TextView = findViewById(R.id.round)

        var roundNum = 0

        val diceText = arrayOf<TextView>(
            findViewById(R.id.aces_text),
            findViewById(R.id.dueces_text),
            findViewById(R.id.threes_text),
            findViewById(R.id.fours_text),
            findViewById(R.id.fives_text),
            findViewById(R.id.sixes_text),
            findViewById(R.id.choice_text),
            findViewById(R.id.four_card_text),
            findViewById(R.id.full_house_text),
            findViewById(R.id.small_straight_text),
            findViewById(R.id.large_straight_text),
            findViewById(R.id.yacht_text)
        )

        val totalUpText: TextView = findViewById(R.id.totalup)
        val totalDownText: TextView = findViewById(R.id.totaldown)
        val bonusText: TextView = findViewById(R.id.bonus)

        val checkUp = BooleanArray(6) { false }
        val checkDown = BooleanArray(6) { false }
        val valueUp = IntArray(6) { 0 }
        val valueDown = IntArray(6) { 0 }
        var sumUp = 0
        var sumDown = 0
        var bonusPoint = 0

        val diceImage = arrayOfNulls<ImageView>(5)

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
                    if (diceText[0].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[0]
                    sumUp += plus_Int
                    diceText[0].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[0] = true
                    valueUp[0] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[0].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[0]
                valueUp[0] = 0
                diceText[0].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[0] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[1].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[1]
                    sumUp += plus_Int
                    diceText[1].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[1] = true
                    valueUp[1] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[1].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[1]
                valueUp[1] = 0
                diceText[1].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[1] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[2].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[2]
                    sumUp += plus_Int
                    diceText[2].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[2] = true
                    valueUp[2] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()

                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[2].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[2]
                valueUp[2] = 0
                diceText[2].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[2] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[3].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[3]
                    sumUp += plus_Int
                    diceText[3].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[3] = true
                    valueUp[3] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[3].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[3]
                valueUp[3] = 0
                diceText[3].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[3] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[4].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[4]
                    sumUp += plus_Int
                    diceText[4].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[4] = true
                    valueUp[4] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[4].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[4]
                valueUp[4] = 0
                diceText[4].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[4] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[5].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumUp -= valueUp[5]
                    sumUp += plus_Int
                    diceText[5].text = ET.text
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[5] = true
                    valueUp[5] = plus_Int
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[5].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumUp -= valueUp[5]
                valueUp[5] = 0
                diceText[5].text = "-"
                bonusText.text = "-"
                totalUpText.text = ("" + sumUp)
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkUp[5] = false
                if (roundNum == 0) totalUpText.text = "-"
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
                    if (diceText[6].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[0]
                    sumDown += plus_Int
                    diceText[6].text = ET.text
                    checkDown[0] = true
                    valueDown[0] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[6].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[0]
                valueDown[0] = 0
                diceText[6].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[0] = false
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
                    if (diceText[7].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[1]
                    sumDown += plus_Int
                    diceText[7].text = ET.text
                    checkDown[1] = true
                    valueDown[1] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[7].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[1]
                valueDown[1] = 0
                diceText[7].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[1] = false
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
                    if (diceText[8].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[2]
                    sumDown += plus_Int
                    diceText[8].text = ET.text
                    checkDown[2] = true
                    valueDown[2] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[8].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[2]
                valueDown[2] = 0
                diceText[8].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[2] = false
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
                    if (diceText[9].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[3]
                    sumDown += plus_Int
                    diceText[9].text = ET.text
                    checkDown[3] = true
                    valueDown[3] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[9].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[3]
                valueDown[3] = 0
                diceText[9].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[3] = false
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
                    if (diceText[10].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[4]
                    sumDown += plus_Int
                    diceText[10].text = ET.text
                    checkDown[4] = true
                    valueDown[4] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[10].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[4]
                valueDown[4] = 0
                diceText[10].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[4] = false
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
                    if (diceText[11].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    val plus_Int: Int = ET.text.toString().toInt()
                    sumDown -= valueDown[5]
                    sumDown += plus_Int
                    diceText[11].text = ET.text
                    checkDown[5] = true
                    valueDown[5] = plus_Int
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                } else Toast.makeText(this, "잘못된 입력입니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            Cancel.setOnClickListener {
                if (diceText[11].getText().toString() != "-")
                    roundText.text = ("Round " + (--roundNum) + "/12")
                sumDown -= valueDown[5]
                valueDown[5] = 0
                diceText[11].text = "-"
                totalDownText.text =
                    if (roundNum == 0) "-" else ("" + (sumUp + sumDown + bonusPoint))
                checkDown[5] = false
                Toast.makeText(this, "[야추] 초기화되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        binding.dice.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.dice_dialog, null)
            val diceValue = arrayOf<Int>(1, 1, 1, 1, 1)
            val throwDice: Button = myLayout.findViewById(R.id.okBtn)

            val diceShowText = arrayOf<TextView>(
                myLayout.findViewById(R.id.text_1),
                myLayout.findViewById(R.id.text_2),
                myLayout.findViewById(R.id.text_3),
                myLayout.findViewById(R.id.text_4),
                myLayout.findViewById(R.id.text_5))

            val diceButton = arrayOf<Button>(
                myLayout.findViewById(R.id.dice_ace),
                myLayout.findViewById(R.id.dice_duece),
                myLayout.findViewById(R.id.dice_triple),
                myLayout.findViewById(R.id.dice_quad),
                myLayout.findViewById(R.id.dice_penta),
                myLayout.findViewById(R.id.dice_hexa),
                myLayout.findViewById(R.id.dice_choice),
                myLayout.findViewById(R.id.dice_fourcard),
                myLayout.findViewById(R.id.dice_fullhouse),
                myLayout.findViewById(R.id.dice_s_straight),
                myLayout.findViewById(R.id.dice_l_straight),
                myLayout.findViewById(R.id.dice_yacht))

            val diceResult = arrayOf<TextView>(
                myLayout.findViewById(R.id.result_ace),
                myLayout.findViewById(R.id.result_duece),
                myLayout.findViewById(R.id.result_triple),
                myLayout.findViewById(R.id.result_quad),
                myLayout.findViewById(R.id.result_penta),
                myLayout.findViewById(R.id.result_hexa),
                myLayout.findViewById(R.id.result_choice),
                myLayout.findViewById(R.id.result_fourcard),
                myLayout.findViewById(R.id.result_fullhouse),
                myLayout.findViewById(R.id.result_s_straight),
                myLayout.findViewById(R.id.result_l_straight),
                myLayout.findViewById(R.id.result_yacht)
            )
            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()

            diceImage[0] = myLayout.findViewById(R.id.dice1)
            diceImage[1] = myLayout.findViewById(R.id.dice2)
            diceImage[2] = myLayout.findViewById(R.id.dice3)
            diceImage[3] = myLayout.findViewById(R.id.dice4)
            diceImage[4] = myLayout.findViewById(R.id.dice5)

            val chance: TextView = myLayout.findViewById(R.id.chance)
            for (i in 0..4) diceImage[i]?.setBackgroundResource(R.drawable.false_bg)
            val stat = Array<Boolean>(5) { false }
            var chanceInt = 0
            val returnValue = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

            for (i in 0..4) {
                diceImage[i]?.setOnClickListener {
                    if (chanceInt == 0)
                        Toast.makeText(this, "고정시킬 수 없습니다", Toast.LENGTH_SHORT).show()
                    else {
                        stat[i] = !stat[i]
                        if (stat[i]) diceImage[i]?.setBackgroundResource(R.drawable.true_bg)
                        else diceImage[i]?.setBackgroundResource(R.drawable.false_bg)
                        if (stat[0] && stat[1] && stat[2] && stat[3] && stat[4]) {

                            var flag = false
                            val Temp_value = diceValue
                            for (i in 0..4) {
                                if (diceValue[i] == 1) returnValue[0]++
                            }
                            diceResult[0].text = "" + returnValue[0]

                            for (i in 0..4) {
                                if (diceValue[i] == 2) returnValue[1] += 2
                            }
                            diceResult[1].text = "" + returnValue[1]

                            for (i in 0..4) {
                                if (diceValue[i] == 3) returnValue[2] += 3
                            }
                            diceResult[2].text = "" + returnValue[2]

                            for (i in 0..4) {
                                if (diceValue[i] == 4) returnValue[3] += 4
                            }
                            diceResult[3].text = "" + returnValue[3]

                            for (i in 0..4) {
                                if (diceValue[i] == 5) returnValue[4] += 5
                            }
                            diceResult[4].text = "" + returnValue[4]

                            for (i in 0..4) {
                                if (diceValue[i] == 6) returnValue[5] += 6
                            }
                            diceResult[5].text = "" + returnValue[5]

                            for (i in 0..4) {
                                returnValue[6] += diceValue[i]
                            }
                            diceResult[6].text = "" + returnValue[6]

                            flag = false
                            Temp_value.sort()
                            if (Temp_value[0] == Temp_value[1] &&
                                Temp_value[1] == Temp_value[2] &&
                                Temp_value[2] == Temp_value[3]
                            )
                                flag = true
                            if (Temp_value[1] == Temp_value[2] &&
                                Temp_value[2] == Temp_value[3] &&
                                Temp_value[3] == Temp_value[4]
                            )
                                flag = true
                            if (flag) for (i in 0..4) returnValue[7] += diceValue[i]
                            diceResult[7].text = "" + returnValue[7]

                            flag = false
                            Temp_value.sort()
                            if (Temp_value[0] == Temp_value[1] &&
                                Temp_value[1] == Temp_value[2] &&
                                Temp_value[3] == Temp_value[4]
                            ) flag = true
                            if (Temp_value[0] == Temp_value[1] &&
                                Temp_value[2] == Temp_value[3] &&
                                Temp_value[3] == Temp_value[4]
                            ) flag = true
                            if (flag) for (i in 0..4) returnValue[8] += diceValue[i]
                            diceResult[8].text = "" + returnValue[8]

                            flag = false
                            Temp_value.sort()
                            Temp_value.distinct()
                            if (Temp_value.size >= 4) {
                                if (Temp_value[0] + 1 == Temp_value[1] &&
                                    Temp_value[1] + 1 == Temp_value[2] &&
                                    Temp_value[2] + 1 == Temp_value[3]
                                ) flag = true
                                if (Temp_value.size >= 5) {
                                    if (Temp_value[1] + 1 == Temp_value[2] &&
                                        Temp_value[2] + 1 == Temp_value[3] &&
                                        Temp_value[3] + 1 == Temp_value[4]
                                    ) flag = true
                                }
                            }
                            if (flag) returnValue[9] = 15
                            diceResult[9].text = "" + returnValue[9]

                            flag = false
                            Temp_value.sort()
                            if (Temp_value[0] + 1 == Temp_value[1] &&
                                Temp_value[1] + 1 == Temp_value[2] &&
                                Temp_value[2] + 1 == Temp_value[3] &&
                                Temp_value[3] + 1 == Temp_value[4]
                            ) flag = true
                            if (flag) returnValue[10] = 30
                            diceResult[10].text = "" + returnValue[10]

                            flag = false
                            if (diceValue[0] == diceValue[1] &&
                                diceValue[1] == diceValue[2] &&
                                diceValue[2] == diceValue[3] &&
                                diceValue[3] == diceValue[4]
                            ) flag = true
                            if (flag) returnValue[11] = 50
                            diceResult[11].text = "" + returnValue[11]
                        } else {
                            for (i in diceResult.indices) {
                                diceResult[i].text = "-"
                                returnValue[i] = 0
                            }
                        }
                    }
                }
            }

            throwDice.setOnClickListener {
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
                if (chanceInt < 3) {
                    for (i in 0..4) if (!stat[i]) {
                        diceImage[i]?.setImageResource(diceID[rand[i]])
                        diceValue[i] = rand[i] + 1
                        diceShowText[i].text = ("" + (rand[i] + 1))
                    }
                    chance.text = ("Chance " + ++chanceInt + "/3")
                } else {
                    Toast.makeText(this, "더 이상 던질 수 없습니다", Toast.LENGTH_SHORT).show()
                }
            }

            diceButton[0].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[0].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[0]
                    sumUp += returnValue[0]
                    diceText[0].text = "" + returnValue[0]
                    totalUpText.text = "" + sumUp
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[0] = true
                    valueUp[0] = returnValue[0]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Single
            diceButton[1].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[1].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[1]
                    sumUp += returnValue[1]
                    diceText[1].text = "" + returnValue[1]
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[1] = true
                    valueUp[1] = returnValue[1]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Double
            diceButton[2].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[2].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[2]
                    sumUp += returnValue[2]
                    diceText[2].text = "" + returnValue[2]
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[2] = true
                    valueUp[2] = returnValue[2]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Triple
            diceButton[3].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[3].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[3]
                    sumUp += returnValue[3]
                    diceText[3].text = "" + returnValue[3]
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[3] = true
                    valueUp[3] = returnValue[3]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Quadra
            diceButton[4].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[4].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[4]
                    sumUp += returnValue[4]
                    diceText[4].text = "" + returnValue[4]
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[4] = true
                    valueUp[4] = returnValue[4]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Penta
            diceButton[5].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[5].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumUp -= valueUp[5]
                    sumUp += returnValue[5]
                    diceText[5].text = "" + returnValue[5]
                    totalUpText.text = ("" + sumUp)
                    val bonus_Int = totalUpText.getText().toString().toInt()
                    if (bonus_Int >= 63) {
                        bonusText.text = "35"
                        bonusPoint = 35
                    }
                    checkUp[5] = true
                    valueUp[5] = returnValue[5]
                    for (i in 0..5) {
                        if (checkUp[i] == false) break
                        if (i == 5) {
                            if (totalUpText.getText().toString().toInt() < 63) {
                                bonusText.text = "0"
                                bonusPoint = 0
                            }
                        }
                    }
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Hexa

            diceButton[6].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[6].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[0]
                    sumDown += returnValue[6]
                    diceText[6].text = "" + returnValue[6]
                    checkDown[0] = true
                    valueDown[0] = returnValue[6]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Choice
            diceButton[7].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[7].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[1]
                    sumDown += returnValue[7]
                    diceText[7].text = "" + returnValue[7]
                    checkDown[1] = true
                    valueDown[1] = returnValue[7]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Four Card
            diceButton[8].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[8].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[2]
                    sumDown += returnValue[8]
                    diceText[8].text = "" + returnValue[8]
                    checkDown[2] = true
                    valueDown[2] = returnValue[8]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Full House
            diceButton[9].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[9].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[3]
                    sumDown += returnValue[9]
                    diceText[9].text = "" + returnValue[9]
                    checkDown[3] = true
                    valueDown[3] = returnValue[9]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Small Straight
            diceButton[10].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[10].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[4]
                    sumDown += returnValue[10]
                    diceText[10].text = "" + returnValue[10]
                    checkDown[4] = true
                    valueDown[4] = returnValue[10]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Large Straight
            diceButton[11].setOnClickListener {
                if (!stat[0] || !stat[1] || !stat[2] || !stat[3] || !stat[4]) {
                    Toast.makeText(this, "모든 주사위를 고정시켜 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    if (diceText[11].getText().toString() == "-")
                        roundText.text = ("Round " + (++roundNum) + "/12")
                    sumDown -= valueDown[5]
                    sumDown += returnValue[11]
                    diceText[11].text = "" + returnValue[11]
                    checkDown[5] = true
                    valueDown[5] = returnValue[11]
                    for (i in 0..5) if (!checkDown[i]) break
                    totalDownText.text = ("" + (sumUp + sumDown + bonusPoint))
                    dialog.dismiss()
                }
            }   //Yacht
        }
        binding.reset.setOnClickListener {
            val myLayout = layoutInflater.inflate(R.layout.reset_dialog, null)
            val reset: Button = myLayout.findViewById(R.id.okBtn)
            val cancel: Button = myLayout.findViewById(R.id.cancelBtn)

            val builder = AlertDialog.Builder(this).apply {
                setView(myLayout)
            }
            val dialog = builder.create()
            dialog.show()
            reset.setOnClickListener {
                roundNum = 0
                sumUp = 0
                sumDown = 0
                bonusPoint = 0
                for (i in 0..5) {
                    valueUp[i] = 0
                    valueDown[i] = 0
                    checkUp[i] = false
                    checkDown[i] = false
                }
                roundText.text = "Round 0/12"

                diceText[0].text = "-"
                diceText[1].text = "-"
                diceText[2].text = "-"
                diceText[3].text = "-"
                diceText[4].text = "-"
                diceText[5].text = "-"

                totalUpText.text = "-"
                bonusText.text = "-"

                diceText[6].text = "-"
                diceText[7].text = "-"
                diceText[8].text = "-"
                diceText[9].text = "-"
                diceText[10].text = "-"
                diceText[11].text = "-"

                totalDownText.text = "-"

                Toast.makeText(this, "초기화 되었습니다", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}