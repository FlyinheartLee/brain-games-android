package com.braingames

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private var backPressedTime: Long = 0

    private val games = listOf(
        Game(1, "数独", "经典数字填充游戏，挑战你的逻辑思维", R.drawable.ic_sudoku,
             "file:///android_asset/sudoku.html"),
        Game(2, "数字迷宫", "在迷宫中寻找正确路径", R.drawable.ic_maze,
             "file:///android_asset/number-maze.html"),
        Game(3, "摩天楼", "根据提示建造摩天大楼", R.drawable.ic_skyscraper,
             "file:///android_asset/skyscraper.html"),
        Game(4, "2048", "滑动合并数字，达到2048", R.drawable.ic_2048,
             "file:///android_asset/game2048.html"),
        Game(5, "华容道", "经典滑块解谜游戏", R.drawable.ic_klotski,
             "file:///android_asset/klotski.html"),
        Game(6, "扫雷", "找出所有隐藏的地雷", R.drawable.ic_minesweeper,
             "file:///android_asset/minesweeper.html"),
        Game(7, "接水管", "旋转管道连接水源", R.drawable.ic_pipe,
             "file:///android_asset/pipe.html"),
        Game(8, "记忆翻牌", "考验你的记忆力", R.drawable.ic_memory,
             "file:///android_asset/memory.html"),
        Game(9, "推箱子", "经典仓库番游戏", R.drawable.ic_sokoban,
             "file:///android_asset/sokoban.html"),
        Game(10, "数桥", "连接岛屿的经典谜题", R.drawable.ic_hashi,
             "file:///android_asset/hashi.html")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        
        gameAdapter = GameAdapter(games) { game ->
            openGame(game)
        }
        recyclerView.adapter = gameAdapter

        // 注册返回键处理
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val currentTime = System.currentTimeMillis()
                if (currentTime - backPressedTime > 2000) {
                    backPressedTime = currentTime
                    Toast.makeText(this@MainActivity, "再按一次退出应用", Toast.LENGTH_SHORT).show()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    private fun openGame(game: Game) {
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra("game_name", game.name)
            putExtra("game_url", game.url)
        }
        startActivity(intent)
    }
}
