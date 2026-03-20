package com.braingames

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
             "https://flyinheartlee.github.io/sudoku/sudoku-h5.html"),
        Game(2, "数字迷宫", "在迷宫中寻找正确路径", R.drawable.ic_maze, 
             "https://flyinheartlee.github.io/sudoku/number-maze.html"),
        Game(3, "摩天楼", "根据提示建造摩天大楼", R.drawable.ic_skyscraper, 
             "https://flyinheartlee.github.io/sudoku/skyscraper.html"),
        Game(4, "2048", "滑动合并数字，达到2048", R.drawable.ic_2048, 
             "https://flyinheartlee.github.io/sudoku/game2048.html"),
        Game(5, "华容道", "经典滑块解谜游戏", R.drawable.ic_klotski, 
             "https://flyinheartlee.github.io/sudoku/klotski.html"),
        Game(6, "扫雷", "找出所有隐藏的地雷", R.drawable.ic_minesweeper, 
             "https://flyinheartlee.github.io/sudoku/minesweeper.html"),
        Game(7, "接水管", "旋转管道连接水源", R.drawable.ic_pipe, 
             "https://flyinheartlee.github.io/sudoku/pipe.html"),
        Game(8, "记忆翻牌", "考验你的记忆力", R.drawable.ic_memory, 
             "https://flyinheartlee.github.io/sudoku/memory.html"),
        Game(9, "推箱子", "经典仓库番游戏", R.drawable.ic_sokoban, 
             "https://flyinheartlee.github.io/sudoku/sokoban.html"),
        Game(10, "数桥", "连接岛屿的经典谜题", R.drawable.ic_hashi, 
             "https://flyinheartlee.github.io/sudoku/hashi.html")
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
    }

    private fun openGame(game: Game) {
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra("game_name", game.name)
            putExtra("game_url", game.url)
        }
        startActivity(intent)
    }

    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - backPressedTime > 2000) {
            backPressedTime = currentTime
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
        }
    }
}
