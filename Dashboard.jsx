import React from 'react';
import { BookOpen, TrendingUp, Users } from 'lucide-react';

const MetricCard = ({ title, value, gradientFrom, gradientTo, icon: Icon }) => {
    const gradientClass = `bg-gradient-to-br ${gradientFrom} ${gradientTo}`;
    return (
        <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl transition-all duration-300 ease-in-out
                        transform hover:shadow-3xl hover:-translate-y-2 border-2 border-purple-200">
            <div className={`flex items-center justify-between p-4 rounded-xl ${gradientClass} shadow-lg`}>
                <Icon className="w-10 h-10 text-white" />
            </div>
            <p 
                className="text-sm font-semibold mt-4 uppercase tracking-wide" 
                style={{ 
                    background: 'linear-gradient(to right, #9333ea, #db2777)',
                    WebkitBackgroundClip: 'text',
                    WebkitTextFillColor: 'transparent',
                    backgroundClip: 'text',
                    color: '#db2777'
                }}
            >
                {title}
            </p>
            <h3 
                className={`text-5xl font-extrabold bg-gradient-to-r ${gradientFrom} ${gradientTo} bg-clip-text text-transparent mt-2 font-sans`}
                style={{
                    background: 'linear-gradient(to right, #9333ea, #db2777)',
                    WebkitBackgroundClip: 'text',
                    WebkitTextFillColor: 'transparent',
                    backgroundClip: 'text'
                }}
            >
                {value}
            </h3>
        </div>
    );
};

const Dashboard = () => {
    return (
        <div className="space-y-8">
            {/* Секция ключевых метрик */}
            <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
                <MetricCard
                    title="Всего Книг"
                    value="12,500"
                    gradientFrom="from-purple-500"
                    gradientTo="to-pink-500"
                    icon={BookOpen}
                />
                <MetricCard
                    title="Книг Выдано"
                    value="850"
                    gradientFrom="from-purple-500"
                    gradientTo="to-pink-500"
                    icon={TrendingUp}
                />
                <MetricCard
                    title="Просрочено"
                    value="45"
                    gradientFrom="from-purple-600"
                    gradientTo="to-pink-600"
                    icon={BookOpen}
                />
                <MetricCard
                    title="Новых Читателей (Месяц)"
                    value="120"
                    gradientFrom="from-purple-500"
                    gradientTo="to-pink-500"
                    icon={Users}
                />
            </div>

            {/* Другие виджеты (например, график активности) */}
            <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
                <h3 
                    className="text-xl font-semibold mb-4 font-sans"
                    style={{
                        background: 'linear-gradient(to right, #9333ea, #db2777)',
                        WebkitBackgroundClip: 'text',
                        WebkitTextFillColor: 'transparent',
                        backgroundClip: 'text'
                    }}
                >
                    Активность выдачи за 6 месяцев
                </h3>
                <div className="h-64 flex items-center justify-center border-2 border-dashed border-purple-300 rounded-lg bg-gradient-to-br from-purple-50 to-pink-50">
                    {/* Здесь будет код для красивого графика */}
                    <p 
                        className="font-semibold" 
                        style={{ 
                            background: 'linear-gradient(to right, #9333ea, #db2777)',
                            WebkitBackgroundClip: 'text',
                            WebkitTextFillColor: 'transparent',
                            backgroundClip: 'text',
                            fontSize: '1.125rem'
                        }}
                    >
                        Нет данных для графика
                    </p>
                </div>
            </div>
        </div>
    );
};

export default Dashboard;