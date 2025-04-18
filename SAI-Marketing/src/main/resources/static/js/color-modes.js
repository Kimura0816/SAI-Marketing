/*!
 * Bootstrap のドキュメントのカラー モード トグル (https://getbootstrap.com/)
 * 著作権 2011-2024 The Bootstrap Authors
 * Creative Commons Attribution 3.0 Unported License に基づいてライセンスされています。
 */

（（） => {
  「厳密な使用」

  const getStoredTheme = () => localStorage.getItem('theme')
  const setStoredTheme = theme => localStorage.setItem('theme', theme)

  const getPreferredTheme = () => {
    const ストアドテーマ = getStoredTheme()
    if (保存されたテーマ) {
      保存されたテーマを返す
    }

    window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light' を返します
  }

  const setTheme = テーマ => {
    if (テーマ === 'auto') {
      document.documentElement.setAttribute('data-bs-theme', (window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'))
    } それ以外 {
      document.documentElement.setAttribute('data-bs-theme', テーマ)
    }
  }

  テーマを設定します(getPreferredTheme())

  const showActiveTheme = (テーマ、フォーカス = false) => {
    const themeSwitcher = document.querySelector('#bd-theme')

    テーマスイッチャーの場合
      戻る
    }

    const themeSwitcherText = document.querySelector('#bd-theme-text')
    const activeThemeIcon = document.querySelector('.theme-icon-active use')
    const btnToActive = document.querySelector(`[data-bs-theme-value="${theme}"]`)
    const svgOfActiveBtn = btnToActive.querySelector('svg use').getAttribute('href')

    document.querySelectorAll('[data-bs-theme-value]').forEach(要素 => {
      要素.classList.remove('アクティブ')
      要素.setAttribute('aria-pressed', 'false')
    })

    btnToActive.classList.add('アクティブ')
    btnToActive.setAttribute('aria-pressed', 'true')
    アクティブテーマアイコン.setAttribute('href', svgOfActiveBtn)
    const themeSwitcherLabel = `${themeSwitcherText.textContent} (${btnToActive.dataset.bsThemeValue})`
    themeSwitcher.setAttribute('aria-label', themeSwitcherLabel)

    if (フォーカス) {
      テーマスイッチャー.focus()
    }
  }

  window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
    const ストアドテーマ = getStoredTheme()
    保存されたテーマが !== 'light' かつ 保存されたテーマが !== 'dark' の場合 {
      テーマを設定します(getPreferredTheme())
    }
  })

  window.addEventListener('DOMContentLoaded', () => {
    アクティブテーマを表示(getPreferredTheme())

    document.querySelectorAll('[data-bs-theme-value]')
      .forEach(トグル => {
        トグル.addEventListener('クリック', () => {
          const theme = toggle.getAttribute('data-bs-theme-value')
          setStoredTheme(テーマ)
          setTheme(テーマ)
          アクティブテーマを表示(テーマ、true)
        })
      })
  })
})()