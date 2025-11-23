import React from 'react'
import { LayoutDashboard, Book, User, PieChart, Settings } from 'lucide-react'

// Компонент боковой панели навигации
export default function Sidebar({ navItems, currentView, setView }) {
    // Массив цветов для кнопок навигации - все розово-фиолетовые
    const buttonColors = [
        { bg: 'bg-gradient-to-r from-purple-500 to-pink-500', hover: 'hover:from-purple-600 hover:to-pink-600', shadow: 'shadow-purple-500/50' },
        { bg: 'bg-gradient-to-r from-pink-500 to-purple-500', hover: 'hover:from-pink-600 hover:to-purple-600', shadow: 'shadow-pink-500/50' },
        { bg: 'bg-gradient-to-r from-purple-600 to-pink-600', hover: 'hover:from-purple-700 hover:to-pink-700', shadow: 'shadow-purple-600/50' },
        { bg: 'bg-gradient-to-r from-pink-600 to-purple-600', hover: 'hover:from-pink-700 hover:to-purple-700', shadow: 'shadow-pink-600/50' },
        { bg: 'bg-gradient-to-r from-purple-500 to-pink-500', hover: 'hover:from-purple-600 hover:to-pink-600', shadow: 'shadow-purple-500/50' },
    ]

    const gradientColors = [
        ['#a855f7', '#ec4899'], // purple to pink
        ['#ec4899', '#a855f7'], // pink to purple
        ['#9333ea', '#db2777'], // deep purple to pink
        ['#db2777', '#9333ea'], // pink to deep purple
        ['#a855f7', '#ec4899'], // purple to pink
    ]

    return (
        <div 
            className="w-64 h-screen bg-white/90 backdrop-blur-lg shadow-2xl p-6 border-r-4 border-purple-500 flex flex-col font-sans"
            style={{
                width: '256px',
                height: '100vh',
                background: 'rgba(255, 255, 255, 0.9)',
                padding: '1.5rem',
                borderRight: '4px solid #9333ea',
                display: 'flex',
                flexDirection: 'column',
                fontFamily: 'Inter, Arial, sans-serif',
                boxShadow: '0 25px 50px -12px rgba(0, 0, 0, 0.25)'
            }}
        >
            <h1 
                className="text-3xl font-extrabold bg-gradient-to-r from-purple-600 via-pink-600 to-blue-600 bg-clip-text text-transparent mb-10 tracking-wider"
                style={{
                    fontSize: '1.875rem',
                    fontWeight: '800',
                    background: 'linear-gradient(to right, #9333ea, #db2777)',
                    WebkitBackgroundClip: 'text',
                    WebkitTextFillColor: 'transparent',
                    backgroundClip: 'text',
                    marginBottom: '2.5rem',
                    letterSpacing: '0.05em'
                }}
            >
                Libris Flow
            </h1>

            <nav className="flex-grow space-y-3">
                {navItems.map((item, index) => {
                    const isActive = currentView === item.name
                    const colors = buttonColors[index % buttonColors.length]
                    const [colorFrom, colorTo] = gradientColors[index % gradientColors.length]
                    
                    return (
                        <button
                            key={item.name}
                            onClick={() => setView(item.name)}
                            className={`flex items-center w-full p-3 rounded-xl transition-all duration-300 font-medium text-lg transform
                                ${isActive
                                ? `${colors.bg} text-white shadow-lg ${colors.shadow} scale-105` 
                                : `bg-white/70 text-gray-700 ${colors.hover} hover:text-white hover:shadow-md hover:scale-105`
                            }`}
                            style={isActive ? {
                                background: `linear-gradient(to right, ${colorFrom}, ${colorTo})`,
                                color: 'white',
                                boxShadow: '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
                                transform: 'scale(1.05)'
                            } : {
                                background: 'rgba(255, 255, 255, 0.7)',
                                color: '#9333ea',
                                fontWeight: '600',
                                backgroundImage: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}
                        >
                            <span className="w-6 h-6 mr-3 inline-flex items-center justify-center">
                                {item.name === 'Обзор' && <LayoutDashboard className="w-6 h-6" />}
                                {item.name === 'Каталог Книг' && <Book className="w-6 h-6" />}
                                {item.name === 'Читатели' && <User className="w-6 h-6" />}
                                {item.name === 'Отчеты' && <PieChart className="w-6 h-6" />}
                                {item.name === 'Настройки' && <Settings className="w-6 h-6" />}
                            </span>
                            {item.name}
                        </button>
                    )
                })}
            </nav>

            <div className="mt-8 pt-4 border-t border-gray-100 text-sm" style={{ 
                background: 'linear-gradient(to right, #9333ea, #db2777)',
                WebkitBackgroundClip: 'text',
                WebkitTextFillColor: 'transparent',
                backgroundClip: 'text'
            }}>
                © 2025 Libris Flow
            </div>
        </div>
    )
}
